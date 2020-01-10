package Jac.mbs.AS.BerettaRadici.Pattern;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Eventi extends JFrame {
	JButton PassaggioMacchina;

	public Eventi(String Titolo) {
		super(Titolo);
		PassaggioMacchina = new JButton("Clicca per confermare il passaggio del veicolo");
		Inizializza();
		this.setVisible(true);
	}

	private void Inizializza()

	{
		this.setBounds(100,1000,450,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		PassaggioMacchina.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(null,"Passaggio confermato correttamente", "TELEPASS",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		PassaggioMacchina.setBounds(130,84,182,92);
		this.getContentPane().add(PassaggioMacchina);
	}

}
