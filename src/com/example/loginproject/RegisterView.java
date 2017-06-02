package com.example.loginproject;

import java.util.ArrayList;
import java.util.List;

import com.example.loginproject.model.RoleModel;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Select;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

import de.bonprix.vaadin.bean.field.BeanItemComboBox;

public class RegisterView extends VerticalLayout implements View{

	private static final long serialVersionUID = 1L;
	public static final String NAME = "Register";

	private FormLayout form;
	private TextField userName;
	private PasswordField password;
	private PasswordField cpassword;
	private Button submit;
	
	
	@Override
	public void enter(ViewChangeEvent event) 
	{
		BeanItemComboBox<RoleModel> beanItemComboBox=new BeanItemComboBox<RoleModel>(RoleModel.class);
		form=new FormLayout();
		userName=new TextField("User Name");
		password=new PasswordField("Enter Password");
		cpassword=new PasswordField("Confirm Password");
		submit=new Button("SUBMIT");
		List<RoleModel> list=new ArrayList<RoleModel>();
		RoleModel rm1=new RoleModel();
		rm1.setRole("Engineer");
		
		RoleModel rm2=new RoleModel();
		rm2.setRole("Tester");
		
		list.add(rm1);
		list.add(rm2);
		
		beanItemComboBox.setWidth("50%");
		
		beanItemComboBox.addValueChangeListener(new ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				beanItemComboBox.addItems(list);
			}
		});
	 
		
		
		submit.addClickListener(new ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				if(password.getValue().equals(cpassword.getValue()))
				{
					UI.getCurrent().getNavigator().navigateTo("Main");
				}
				else
				{
					System.out.println("Ravi");
					Notification.show("Invalid Password", Type.ERROR_MESSAGE);
				}
			}
		});
		
		form.addComponents(userName,password,cpassword,beanItemComboBox,submit);
		addComponent(form);
		
	}

}
