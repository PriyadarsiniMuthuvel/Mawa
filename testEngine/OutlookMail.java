package testEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

import org.jsoup.Jsoup;

public class OutlookMail {
	public static void main(String[] args) throws InterruptedException, MessagingException, Exception {
		// TODO Auto-generated method stub
		
		String username = "sophiya@mstsolutions.com";
		String password = "sophi.621218";
		String hostname = "imap.outlook.com";
		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");
		
		Session session = Session.getInstance(props, null);
		Store store = session.getStore();
		store.connect(hostname, username, password);
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);
		
		int count = inbox.getUnreadMessageCount();
		int totalCount = inbox.getMessageCount();
		
		for(int i=0; i<count;i++){
			
			int countEmail = totalCount-i;
			Message msg = inbox.getMessage(countEmail);
			
			Object output = msg.getContent();
			if (output instanceof Multipart) {  
			    Multipart mp = (Multipart)output;
			    int j = mp.getCount();
			    BodyPart bp = mp.getBodyPart(1);
			    String content_email = bp.getContent().toString();
			    System.out.println(content_email);
			    String parsed_content = Jsoup.parse(content_email).text();
			    System.out.println(parsed_content);
			    
			    List<String> extractedUrls=extractUrls(content_email);
			    for (String url : extractedUrls)
			    {
			    	if(url.contains("DiagnosisVerification")){
			    		System.out.println(url);
			    	}
			    }
			     
		    }
		   	else if(output instanceof String){
				
		        System.out.println("Subject: " + msg.getSubject());
		        System.out.println("From: " + msg.getFrom()[0]);
		        System.out.println("Body: "+ msg.getContent());
			}
		}
    }
	
	public static List<String> extractUrls(String text)
	{
	    List<String> containedUrls = new ArrayList<String>();
	    String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
	    Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
	    Matcher urlMatcher = pattern.matcher(text);

	    while (urlMatcher.find())
	    {
	        containedUrls.add(text.substring(urlMatcher.start(0),
	                urlMatcher.end(0)));
	    }

	    return containedUrls;
	}
}


