package Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HouseGUI extends JFrame{
	
	private static final int Height=200;
	
	private static final int Width=100;
	
	
	private static JLabel Income, AnnualRate, Years, PV, Debt, Blank;
	
	private static JTextField IncomeText, DebtText, AnnualRateText, YearsText, PVText;
	
	private static JButton CalcButton;
	
	
	private static CalculateButtonHandler CalcHandler;
	
	// Configures the window
	
	public static void HouseGUI(){
		
		//Labels
		Income = new JLabel("Income: ", SwingConstants.RIGHT);
		
		AnnualRate = new JLabel("Interest: ", SwingConstants.RIGHT);
		
		Years = new JLabel("Years: ", SwingConstants.RIGHT);
		
		Debt = new JLabel("Debt: ", SwingConstants.RIGHT);
		
		PV = new JLabel("Present Value: ",SwingConstants.RIGHT);
		
		Blank =  new JLabel("");
		
		// Text Fields
		IncomeText = new JTextField(8);
		
		AnnualRateText = new JTextField(8);
		
		YearsText = new JTextField(8);
		
		DebtText = new JTextField(8);
		
		PVText = new JTextField(8);
		
		// Calculation Button
		CalcButton = new JButton("Calculate");
		
		CalcHandler = new CalculateButtonHandler();
		
		CalcButton.addActionListener(CalcHandler);
		
		// Frame
		
		JFrame frame = new JFrame();
		
		frame.setBounds(Width, Width, Height, Height);
		
		frame.setTitle("Calculator");
		
		Container pane = frame.getContentPane();
		
		pane.setLayout(new GridLayout(6,2));
		
		//Panels		
		pane.add(Income);
		
		pane.add(IncomeText);
		
		pane.add(AnnualRate);
		
		pane.add(AnnualRateText);
		
		pane.add(Years);
		
		pane.add(YearsText);
		
		pane.add(Debt);
		
		pane.add(DebtText);
		
		pane.add(PV);
		
		pane.add(PVText);
		
		pane.add(Blank);
		
		pane.add(CalcButton);
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	// Reference the CalcEngine	
	private static class CalculateButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			House engine = new House();
			
			double PV, AnnualRate, Income, Debt, Years;
			
			Income=Double.parseDouble(IncomeText.getText());
			
			Debt=Double.parseDouble(DebtText.getText());
			
			Years=Double.parseDouble(YearsText.getText());
			
			AnnualRate=Double.parseDouble(AnnualRateText.getText());
			
			
			PV = engine.HouseValue(Income, Debt, Years, AnnualRate);
			
			PVText.setText(""+PV);
		}
	}
	
	
	public static void main(String[] args) {
		HouseGUI();

	}
	
}