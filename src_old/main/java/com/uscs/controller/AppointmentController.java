package com.uscs.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uscs.common.config.utils.mockAppointment.MockAppointment;
import com.uscs.model.AppointmentVO;
import com.uscs.model.ReceiptVO;
import com.uscs.model.WarehouseVO;
import com.uscs.service.AppointmentService;
import com.uscs.service.ReceiptService;
import com.uscs.service.Validation;
import com.uscs.service.WarehouseService;

@Controller
public class AppointmentController {

	@Inject
	WarehouseService warehouseService;
		
	@Inject
	AppointmentService appointmentService;
	
	@Inject
	ReceiptService receiptService;
	
	@RequestMapping("/")
	public ModelAndView index(Model model){
		
		List<WarehouseVO> warehouseList = warehouseService.getWarehouseList();
		
		ModelAndView indexView = new ModelAndView("index");
		model.addAttribute("warehouseList",warehouseList);
		System.out.println(warehouseList.toString());
		return indexView;
	}
		
	@RequestMapping(value = "/createAppointment", method = RequestMethod.POST)
	public ModelAndView createAppointment(Model model,HttpSession session,
			RedirectAttributes redirect,
			@RequestParam("reNumber1")String reNumber1,
			@RequestParam("reNumber2")String reNumber2,
			@RequestParam("reNumber3")String reNumber3,
			@RequestParam("apptNumber")String apptNumber,
			@RequestParam("whseSysId")Long whseSysId){
		
		MockAppointment mockAppt = new MockAppointment();
		List<ReceiptVO> receiptList = new ArrayList<ReceiptVO>();
		List<AppointmentVO> apptList = new ArrayList<AppointmentVO>();
		AppointmentVO appt = new AppointmentVO();
		Validation validation = new Validation();
		boolean apptCreateError = false;
		boolean hasRec = false;
		boolean linkRecError = false;
		boolean hasError = false;
		boolean error = false;
		boolean success = true;
		boolean warning = false;
		boolean isValid = false;
		String EMPTY = "";
		long appointmentNumber = 0;
		long apptSysID = 0;
		
	
		if(!apptNumber.equals(EMPTY)){
			 appointmentNumber = (Long.parseLong(apptNumber));
		}
		
		ReceiptVO reNum1 = new ReceiptVO();
		
			if(validation.validateInputData(reNumber1)){
			reNum1.setRecNumber(Long.parseLong(reNumber1)); 
			receiptList.add(reNum1);
			isValid = true;
			}
		if(!reNumber2.equals(EMPTY)){
			isValid = false;
			ReceiptVO reNum2 = new ReceiptVO();
			if(validation.validateInputData(reNumber2)){
				reNum2.setRecNumber(Long.parseLong(reNumber2)); 
				receiptList.add(reNum2);
				isValid = true;
				}
			}
		if(!reNumber3.equals(EMPTY)){
			isValid = false;
			ReceiptVO reNum3 = new ReceiptVO();
			if(validation.validateInputData(reNumber3)){
				reNum3.setRecNumber(Long.parseLong(reNumber3)); 
				receiptList.add(reNum3);
				isValid = true;
				}
			}
		hasRec = receiptService.receiptExsists(receiptList, whseSysId);
		
		if(isValid && hasRec){
			
			apptList = mockAppt.createMockAppointment(whseSysId, receiptList);
			
			if(apptNumber.equals(EMPTY)){
				apptList = appointmentService.createAppointment(apptList);	
				apptSysID = apptList.get(0).getApptSysId();
			}else{
				appt.setApptNumber(appointmentNumber);
				appt.setWhseSysId(whseSysId);
				
				apptSysID = appointmentService.getAppointment(appt);
			}
		
			if(apptSysID > 0l){
				
				linkRecError = receiptService.linkAppointment(receiptList,apptSysID,whseSysId);
				
				redirect.addFlashAttribute("success", success);
				return new ModelAndView("redirect:/");
			}else{
				hasError = true;
			}		
		}
			
			if(!hasRec){
				//to:do add ability to return receipt and warehouse info
				redirect.addFlashAttribute("noReceipt", true);
				/*redirect.addFlashAttribute("recNum", recNum);
				redirect.addFlashAttribute("WhseName", whseName);*/
			}
			if(!isValid){
				redirect.addFlashAttribute("badData", true);
			}
			if(hasError){
				redirect.addFlashAttribute("error", true);
			}
			return new ModelAndView("redirect:/");
		}
		
	}
