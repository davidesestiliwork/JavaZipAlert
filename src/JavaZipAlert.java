/*
	JavaZip Alert
	Copyright (C) 2023 Davide Sestili

	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JavaZipAlert extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int exitCode;
	
	public JavaZipAlert(String fileName)
	{
		super("JavaZip Alert");
		
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent arg0)
			{
				System.exit(exitCode);
			}
		});
		
		File zipFile = new File(fileName + ".zip");
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(1, 1));
		
		JLabel label = new JLabel();
		label.setFont(new Font("Arial", Font.PLAIN, 30));
		getContentPane().add(label);
	
		if(zipFile.exists())
		{
			label.setText(zipFile.getAbsolutePath() + " already exists");
			label.setForeground(Color.RED);
			exitCode = 1;
		}
		else
		{
			label.setText(zipFile.getAbsolutePath() + " doesn\'t exist");
			label.setForeground(Color.GREEN);
			exitCode = 0;
		}

		setSize(700, 150);
	}
	
	public static void main(String[] args) 
	{
		if(args.length == 1)
		{
			new JavaZipAlert(args[0]).setVisible(true);
		}
		else
		{
			System.out.println("Usage: directory that should be zipped");
		}
	}
}
