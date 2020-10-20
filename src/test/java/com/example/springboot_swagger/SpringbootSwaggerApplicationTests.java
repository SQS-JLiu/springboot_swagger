package com.example.springboot_swagger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootSwaggerApplicationTests {

	@Autowired
	JavaMailSender javaMailSender;

	@Test
	void contextLoads() {//发送个简单的邮件
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setSubject("测试标题");
		mailMessage.setText("这个是消息的内容");

		mailMessage.setTo("664838289@qq.com");
		mailMessage.setFrom("664838289@qq.com");

		javaMailSender.send(mailMessage);
	}


	@Test
	void contextLoads2() throws MessagingException {//发送个复杂的邮件
		MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();

		//组装
		MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,true);

		helper.setSubject("测试复杂邮件主题");
		helper.setText("<p style='color:red'>这是带样式的内容</p>",true);

		//添加附件
		String filePath = "E:\\IdeaProjects\\springboot_swagger\\src\\main\\resources\\static\\favicon.png";
		helper.addAttachment("1.png",new File(filePath));
		helper.addAttachment("2.png",new File(filePath));

		helper.setTo("664838289@qq.com");
		helper.setFrom("664838289@qq.com");

		javaMailSender.send(mimeMailMessage);
	}


}
