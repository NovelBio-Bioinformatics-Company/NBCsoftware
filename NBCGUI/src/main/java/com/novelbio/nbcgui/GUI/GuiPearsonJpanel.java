package com.novelbio.nbcgui.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import com.novelbio.analysis.coexp.simpCoExp.CoExp;
import com.novelbio.analysis.coexp.simpCoExp.SimpCoExp;
import com.novelbio.base.dataOperate.ExcelOperate;
import com.novelbio.base.fileOperate.FileOperate;
import com.novelbio.base.gui.GUIFileOpen;
import com.novelbio.base.gui.JComboBoxData;
import com.novelbio.base.gui.JScrollPaneData;
import com.novelbio.base.gui.JTextFieldData;
import com.novelbio.database.model.species.Species;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class GuiPearsonJpanel extends JPanel{

	private JTabbedPane jTabbedPanePathResult;
	private JButton jBtbSavePath;
	private JProgressBar jProgressBarPath;
	private JLabel jLabResultReviewPath;
	private JLabel jLabInputReviewPath;
	private JLabel jLabPathPath;
	private JTextField jTxtFilePathPath;
	private JButton jBtnFileOpenPath;
	private JTextFieldData jTxtPvalueCufoff;
	private JComboBoxData<Species> jCombSelSpePath;
	private JLabel jLabPathQtaxID;
	private JScrollPaneData jScrollPaneInputPath;
	private JLabel lblPvaluecutoff;
	////////////	
	
	public GuiPearsonJpanel() 
	{
		

		setPreferredSize(new java.awt.Dimension(1046, 617));
	
		setAlignmentX(0.0f);
		setComponent();
		setLayout(null);
		add(jTxtFilePathPath);
		add(jCombSelSpePath);
		add(jLabPathQtaxID);
		add(jLabPathPath);
		add(jBtbSavePath);
		add(jTxtPvalueCufoff);
		add(jBtnFileOpenPath);
		add(jLabInputReviewPath);
		add(jScrollPaneInputPath);
		add(jTabbedPanePathResult);
		add(jLabResultReviewPath);
		add(jProgressBarPath);
		{
			lblPvaluecutoff = new JLabel("PvalueCutOff");
			lblPvaluecutoff.setBounds(14, 248, 129, 18);
			add(lblPvaluecutoff);
		}
	}
	private void setComponent() {
		{
			jLabPathQtaxID = new JLabel();
			jLabPathQtaxID.setBounds(14, 101, 129, 18);
			jLabPathQtaxID.setText("Query Species");
		}
		{
			jTxtFilePathPath = new JTextField();
			jTxtFilePathPath.setBounds(14, 38, 217, 24);
			jTxtFilePathPath.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
						try {
							setPathProview(jTxtFilePathPath.getText());
						} catch (Exception e) {
							System.out.println("mei you wen jian");
						}
						
					}
				}
			});
		}
		{
			jBtnFileOpenPath = new JButton();
			jBtnFileOpenPath.setBounds(124, 69, 105, 25);
			jBtnFileOpenPath.setText("LoadData");
			jBtnFileOpenPath.setMargin(new java.awt.Insets(1, 1, 1, 1));
			jBtnFileOpenPath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					GUIFileOpen guiFileOpen = new GUIFileOpen();
					String filename = guiFileOpen.openFileName("txt/excel2003", "txt","xls");
					jTxtFilePathPath.setText(filename);
					try {
						setPathProview(jTxtFilePathPath.getText());
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("mei you wen jian");
					}
				}
			});
		}
		{
			jLabPathPath = new JLabel();
			jLabPathPath.setBounds(14, 13, 85, 18);
			jLabPathPath.setText("InputData");
		}
		{
			jTxtPvalueCufoff = new JTextFieldData();
			jTxtPvalueCufoff.setBounds(14, 277, 85, 20);
			jTxtPvalueCufoff.setNumOnly(5);
		}


		{
			jScrollPaneInputPath = new JScrollPaneData();
			jScrollPaneInputPath.setBounds(245, 38, 794, 192);
		}
		{
			jLabInputReviewPath = new JLabel();
			jLabInputReviewPath.setBounds(245, 13, 97, 18);
			jLabInputReviewPath.setText("InputReview");
		}
		{
			jLabResultReviewPath = new JLabel();
			jLabResultReviewPath.setBounds(252, 248, 127, 18);
			jLabResultReviewPath.setText("ResultReview");
		}
		{
			jProgressBarPath = new JProgressBar();
			jProgressBarPath.setBounds(14, 617, 1025, 14);
		}
		{
			jTabbedPanePathResult = new JTabbedPane();
			jTabbedPanePathResult.setBounds(245, 273, 794, 331);
		}
		{
			jBtbSavePath = new JButton();
			jBtbSavePath.setBounds(14, 310, 92, 23);
			jBtbSavePath.setText("Save As");
			jBtbSavePath.setMargin(new java.awt.Insets(1, 0, 1, 0));
			jBtbSavePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					GUIFileOpen guiFileOpen = new GUIFileOpen();
					String savefilename = guiFileOpen.saveFileName("xls", "xls");
					if (!FileOperate.getFileNameSep(savefilename)[1].equals("xls")) {
						savefilename = savefilename+".xls";
					}
					try {
						ExcelOperate excelOperate = new ExcelOperate();
						String inputFile = jTxtFilePathPath.getText();
						excelOperate.openExcel(inputFile);
						int ColNum = excelOperate.getColCount(1);
						ArrayList<String[]> aaa = excelOperate.ReadLsExcel(1, 1, 1, ColNum);
						ColNum = 0;
						for (int i = 0; i < aaa.get(0).length; i++) {
							if (aaa.get(0)[i]!=null && !aaa.get(0)[i].trim().equals("")) {
								ColNum++;
							}
						}
						int[] columnID = new int[ColNum];
						for (int i = 0; i < ColNum ; i++) {
							columnID[i] = i+1;
						}
						CoExp coExp = new CoExp();
						coExp.setPvalueCutoff( Double.parseDouble(jTxtPvalueCufoff.getText()));
						coExp.readTxtExcel(inputFile, columnID);
						coExp.writeToExcel(savefilename);
						SimpCoExp.getCoExpInfo(jTxtFilePathPath.getText(), columnID,9606 , Double.parseDouble(jTxtPvalueCufoff.getText()), savefilename, false);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			});
		}
		
		jCombSelSpePath = new JComboBoxData<Species>();
		jCombSelSpePath.setBounds(14, 126, 174, 23);
		jCombSelSpePath.setMapItem(Species.getSpeciesName2Species(Species.KEGGNAME_SPECIES));
		initial();
		
	}
	
	private void initial() {
		jTxtPvalueCufoff.setText("0.05");
	}
	/**
	 * 查看文件的鼠标或键盘事件响应时调用
	 */
	private void setPathProview(String filePath) {
		ExcelOperate excelOperate = new ExcelOperate();
		excelOperate.openExcel(filePath);
		ArrayList<String[]> PathRawData = excelOperate.ReadLsExcel(1, 1, excelOperate.getRowCount(), excelOperate.getColCount());
		jScrollPaneInputPath.setItemLs(PathRawData);
	}
}
