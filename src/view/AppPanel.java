package view;

import java.awt.event.*;
import javax.swing.*;
import controller.AppController;

public class AppPanel extends JPanel
	{
		private AppController controller;
		private SpringLayout layout;

		private JLabel firstNameLabel;
		private JLabel lastNameLabel;
		private JLabel userNumberLabel;
		private JLabel userMailLabel;

		private JTextField firstNameField;
		private JTextField lastNameField;
		private JTextField userNumberField;
		private JTextField userMailField;

		private JComboBox<String> selectEmailBox;

		private JButton createButton;
		private JButton clearButton;

		public AppPanel(AppController controller)
			{
				this.controller = controller;
				layout = new SpringLayout();

				firstNameLabel = new JLabel("Enter your first name :");
				lastNameLabel = new JLabel("Enter your last name :");
				userNumberLabel = new JLabel("<html>Enter your phone number starting with the area code<br>Example : 8015694700</html>");
				userMailLabel = new JLabel("Enter your email :");

				firstNameField = new JTextField();
				lastNameField = new JTextField();
				userNumberField = new JTextField();
				userMailField = new JTextField();

				String[] emailList = new String[]
					{ "@ Gmail.com", "@ Yahoo.com", "@ Outlook.com", "@ AOL.com", "@ Comcast.net", "@ Hotmail.com" };
				selectEmailBox = new JComboBox<>(emailList);

				createButton = new JButton("Create Account");
				clearButton = new JButton("Clear Fields");

				buildComponents();
				buildListeners();
				buildPlacements();
			}

		private void buildComponents()
			{
				setLayout(layout);
				add(firstNameLabel);
				add(lastNameLabel);
				add(userNumberLabel);
				add(userMailLabel);

				add(firstNameField);
				add(lastNameField);
				add(userNumberField);
				add(userMailField);

				add(selectEmailBox);

				add(createButton);
				add(clearButton);
			}

		private void buildListeners()
			{
				clearButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent clicked)
						{
							controller.clearFields();
						}
					});
				
				createButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent clicked)
						{
							controller.createAccount();
						}
					});
			}

		private void buildPlacements()
			{
				layout.putConstraint(SpringLayout.NORTH, firstNameLabel, 10, SpringLayout.NORTH, this);
				layout.putConstraint(SpringLayout.WEST, firstNameLabel, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.WEST, lastNameLabel, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.WEST, userNumberLabel, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.WEST, userMailLabel, 10, SpringLayout.WEST, this);

				layout.putConstraint(SpringLayout.EAST, firstNameField, -300, SpringLayout.EAST, this);
				layout.putConstraint(SpringLayout.NORTH, lastNameLabel, 50, SpringLayout.SOUTH, firstNameField);
				layout.putConstraint(SpringLayout.NORTH, firstNameField, 5, SpringLayout.SOUTH, firstNameLabel);
				layout.putConstraint(SpringLayout.WEST, firstNameField, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.EAST, lastNameField, -300, SpringLayout.EAST, this);
				layout.putConstraint(SpringLayout.NORTH, userNumberLabel, 50, SpringLayout.SOUTH, lastNameField);
				layout.putConstraint(SpringLayout.NORTH, lastNameField, 5, SpringLayout.SOUTH, lastNameLabel);
				layout.putConstraint(SpringLayout.WEST, lastNameField, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.EAST, userNumberField, -300, SpringLayout.EAST, this);
				layout.putConstraint(SpringLayout.NORTH, userMailLabel, 50, SpringLayout.SOUTH, userNumberField);
				layout.putConstraint(SpringLayout.NORTH, userNumberField, 5, SpringLayout.SOUTH, userNumberLabel);
				layout.putConstraint(SpringLayout.WEST, userNumberField, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, userMailField, 5, SpringLayout.SOUTH, userMailLabel);
				layout.putConstraint(SpringLayout.WEST, userMailField, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.EAST, userMailField, -300, SpringLayout.EAST, this);

				layout.putConstraint(SpringLayout.NORTH, selectEmailBox, 73, SpringLayout.SOUTH, userNumberField);
				layout.putConstraint(SpringLayout.WEST, selectEmailBox, 0, SpringLayout.EAST, userMailField);

				layout.putConstraint(SpringLayout.NORTH, clearButton, 50, SpringLayout.SOUTH, userMailField);
				layout.putConstraint(SpringLayout.WEST, clearButton, 10, SpringLayout.EAST, createButton);
				layout.putConstraint(SpringLayout.EAST, clearButton, 200, SpringLayout.EAST, createButton);
				layout.putConstraint(SpringLayout.NORTH, createButton, 50, SpringLayout.SOUTH, userMailField);
				layout.putConstraint(SpringLayout.WEST, createButton, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.EAST, createButton, 0, SpringLayout.EAST, userMailField);
			}

		public JTextField getFirstNameField()
			{
				return firstNameField;
			}

		public JTextField getLastNameField()
			{
				return lastNameField;
			}

		public JTextField getUserNumberField()
			{
				return userNumberField;
			}

		public JTextField getUserMailField()
			{
				return userMailField;
			}

		public JComboBox<String> getSelectEmailBox()
			{
				return selectEmailBox;
			}
	}
