package com.uscs.service;




import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.rjssoft.webdocs.windows.webservice.client.WebDocsWebServiceClient;
import com.uscs.config.ExternalProperties;



@Service
public class WebDocsServiceImpl implements WebDocsService {

	@Inject
	ExternalProperties properties;

	

		
		public void submitDocument (String fileName) {
			 
			
			String url = properties.getServerAddress();
			
			WebDocsWebServiceClient client = new WebDocsWebServiceClient(url);
			
			boolean result = client.login(
					"", 
					properties.getUserName(),
					properties.getPassword());
			
			if (client.isLoggedIn()){
				
				try {
					result = client.uploadFile(properties.getCompletePath()+fileName+".pdf",fileName+".pdf",false);
				} catch (Exception e) {
					result = true;
				}
				
				
				if(result){
				
					client.addNewDocument(properties.getOutboundTypeKey(),properties.getOutboundFolderKey(),
							fileName+".pdf", "Ticket", "800", "AMY",
							"Ticket#", "Customer Order#", "PO#", "key06", "key07", "key08", "key09", "key10", "key11",
							"key12", "key13", "key14", "key15", "key16", "key17", "key18", "key19", "key20", 
							"key21", "key22","key23", "key24", "key25", "key26", "key27", "key28", "key29", 
							"key30", true); //boolean is deleteTempFileAfterCheckin
				}
			}else{
			
				
				
			}
			
			
		}
		
	public void retriveDocument (String fileName) {
		
	
		
	}

	
}
