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

		private JButton createButton;

		public AppPanel(AppController controller)
			{
				this.controller = controller;
				layout = new SpringLayout();

				firstNameLabel = new JLabel("First Name:");
				lastNameLabel = new JLabel("Last Name:");
				userNumberLabel = new JLabel("Phone Number:");
				userMailLabel = new JLabel("Email:");

				firstNameField = new JTextField();
				layout.putConstraint(SpringLayout.NORTH, lastNameLabel, 32, SpringLayout.SOUTH, firstNameField);
				layout.putConstraint(SpringLayout.SOUTH, firstNameField, 51, SpringLayout.SOUTH, firstNameLabel);
				lastNameField = new JTextField();
				
								layout.putConstraint(SpringLayout.EAST, firstNameField, 0, SpringLayout.EAST, lastNameField);
				layout.putConstraint(SpringLayout.NORTH, userNumberLabel, 32, SpringLayout.SOUTH, lastNameField);
				layout.putConstraint(SpringLayout.SOUTH, lastNameField, 51, SpringLayout.SOUTH, lastNameLabel);
				userNumberField = new JTextField();
				layout.putConstraint(SpringLayout.EAST, lastNameField, 0, SpringLayout.EAST, userNumberField);
				layout.putConstraint(SpringLayout.NORTH, userMailLabel, 32, SpringLayout.SOUTH, userNumberField);
				layout.putConstraint(SpringLayout.SOUTH, userNumberField, 51, SpringLayout.SOUTH, userNumberLabel);
				userMailField = new JTextField();
				layout.putConstraint(SpringLayout.EAST, userNumberField, 0, SpringLayout.EAST, userMailField);
				layout.putConstraint(SpringLayout.SOUTH, userMailField, 45, SpringLayout.SOUTH, userMailLabel);


				createButton = new JButton("Create Account");
				layout.putConstraint(SpringLayout.NORTH, createButton, 38, SpringLayout.SOUTH, userMailField);
				layout.putConstraint(SpringLayout.SOUTH, createButton, -75, SpringLayout.SOUTH, this);
				layout.putConstraint(SpringLayout.EAST, userMailField, 0, SpringLayout.EAST, createButton);
				layout.putConstraint(SpringLayout.WEST, createButton, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.EAST, createButton, -10, SpringLayout.EAST, this);

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

				add(createButton);
			}

		private void buildListeners()
			{
				
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
				layout.putConstraint(SpringLayout.NORTH, firstNameField, 5, SpringLayout.SOUTH, firstNameLabel);
				layout.putConstraint(SpringLayout.WEST, firstNameField, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, lastNameField, 5, SpringLayout.SOUTH, lastNameLabel);
				layout.putConstraint(SpringLayout.WEST, lastNameField, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, userNumberField, 5, SpringLayout.SOUTH, userNumberLabel);
				layout.putConstraint(SpringLayout.WEST, userNumberField, 10, SpringLayout.WEST, this);
				layout.putConstraint(SpringLayout.NORTH, userMailField, 5, SpringLayout.SOUTH, userMailLabel);
				layout.putConstraint(SpringLayout.WEST, userMailField, 10, SpringLayout.WEST, this);
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

	}
