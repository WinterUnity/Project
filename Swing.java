import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class Swing {

	private JFrame frame;
	private JTextField textMasp;
	private JTextField textTensp;
	private JTextField textSL;
	private JLabel lblNewLabel_2_2;
	private JTextField textGia;
	private JLabel lblNewLabel_2_3;
	private JTable table;
	protected JComboBox comboBoxLoaisp;
	/**
	 * Launch the application.
	 */
	Vector Vtieude = new Vector();
	Vector Vnoidung = new Vector();
	Vector Vdong;

	DefaultTableModel dtm = new DefaultTableModel();

	void tieuDe() {
		Vtieude.add("Masp");
		Vtieude.add("Loai sp");
		Vtieude.add("Tensp");
		Vtieude.add("SoLuong");
		Vtieude.add("Gia");
		Vtieude.add("ThanhTien");
		dtm.addColumn(Vtieude);

	}

	void Nhap(SanPham sp) {
		Vdong = new Vector();
		Vdong.add(sp.getMsp());
		if (comboBoxLoaisp.getSelectedIndex() == 0) {
			Vdong.add("DIEN THOAI");
		}
		if (comboBoxLoaisp.getSelectedIndex() == 1) {
			Vdong.add("DIEN LANH");
		}
		if (comboBoxLoaisp.getSelectedIndex() == 2) {
			Vdong.add("DIEN GIA DUNG");
		}
		if (comboBoxLoaisp.getSelectedIndex() == 3) {
			Vdong.add("KHAC");
		}
		Vdong.add(sp.getTensp());
		Vdong.add(sp.getSoluong());
		Vdong.add(sp.getGia());
		Vdong.add(sp.tinhtien());
		Vnoidung.add(Vdong);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Swing window = new Swing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public Swing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		tieuDe();
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBounds(100, 100, 810, 673);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\tMA SAN PHAM");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(10, 40, 182, 40);
		frame.getContentPane().add(lblNewLabel_1);

		textMasp = new JTextField();
		textMasp.setHorizontalAlignment(SwingConstants.CENTER);
		textMasp.setBounds(230, 55, 538, 21);
		frame.getContentPane().add(textMasp);
		textMasp.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("TEN SAN PHAM");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_2.setBounds(10, 78, 182, 40);
		frame.getContentPane().add(lblNewLabel_2);

		textTensp = new JTextField();
		textTensp.setHorizontalAlignment(SwingConstants.CENTER);
		textTensp.setColumns(10);
		textTensp.setBounds(230, 93, 538, 21);
		frame.getContentPane().add(textTensp);

		JLabel lblNewLabel_2_1 = new JLabel("SO LUONG");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(10, 118, 182, 40);
		frame.getContentPane().add(lblNewLabel_2_1);

		textSL = new JTextField();
		textSL.setColumns(10);
		textSL.setBounds(230, 133, 538, 21);
		frame.getContentPane().add(textSL);

		lblNewLabel_2_2 = new JLabel("DON GIA");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_2_2.setBounds(10, 158, 182, 40);
		frame.getContentPane().add(lblNewLabel_2_2);

		textGia = new JTextField();
		textGia.setColumns(10);
		textGia.setBounds(230, 178, 538, 21);
		frame.getContentPane().add(textGia);

		lblNewLabel_2_3 = new JLabel("LOAI SAN PHAM");
		lblNewLabel_2_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_2_3.setBounds(10, 197, 182, 40);
		frame.getContentPane().add(lblNewLabel_2_3);

		comboBoxLoaisp = new JComboBox();
		comboBoxLoaisp.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboBoxLoaisp.setModel(
				new DefaultComboBoxModel(new String[] { "DIEN THOAI", "DIEN LANH", "DIEN GIA DUNG", "KHAC" }));
		comboBoxLoaisp.setBounds(240, 216, 165, 21);
		frame.getContentPane().add(comboBoxLoaisp);
//THEM
		JButton btnThem = new JButton("THEM");
		btnThem.setIcon(new ImageIcon(
				"D:\\Project\\bin\\image\\imagesadd.png"));
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				SanPham s = null;
				String masp = textMasp.getText();
				String tensp = textTensp.getText();
				int soluong = Integer.parseInt(textSL.getText());
				int gia = Integer.parseInt(textGia.getText());
				if (comboBoxLoaisp.getSelectedIndex() == 0) {
					s = new DienThoai(masp, tensp, soluong, gia);

				}
				if (comboBoxLoaisp.getSelectedIndex() == 1) {
					s = new DienLanh(masp, tensp, soluong, gia);

				}
				if (comboBoxLoaisp.getSelectedIndex() == 2) {
					s = new DienGiaDung(masp, tensp, soluong, gia);

				}
				if (comboBoxLoaisp.getSelectedIndex() == 3) {
					s = new Khac(masp, tensp, soluong, gia);

				}

				Nhap(s);
				dtm.setDataVector(Vnoidung, Vtieude);
				table.setModel(dtm);

				/*
				 * for (int i = 0; i <= Vdong.size(); i++) { Vector<SanPham> sv =
				 * (Vector<SanPham>) Vdong.get(i); dtm.addRow(sv); }
				 */
			}
		});

		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(28, 282, 121, 30);
		frame.getContentPane().add(btnThem);
//SUA
		JButton btnSua = new JButton("SUA");
		btnSua.setIcon(
				new ImageIcon("D:\\Project\\bin\\image\\repair.jpg"));
		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (table.getSelectedRow() != -1) {
					int m = Integer.parseInt(textSL.getText());
					int n = Integer.parseInt(textGia.getText());
					int result = m * n;

					dtm.setValueAt(textMasp.getText(), table.getSelectedRow(), 0);
					dtm.setValueAt(textTensp.getText(), table.getSelectedRow(), 1);
					dtm.setValueAt(m, table.getSelectedRow(), 3);
					dtm.setValueAt(n, table.getSelectedRow(), 4);
					dtm.setValueAt(result, table.getSelectedRow(), 5);

					if (comboBoxLoaisp.getSelectedIndex() == 0) {
						dtm.setValueAt("DIEN THOAI", table.getSelectedRow(), 2);
					}
					if (comboBoxLoaisp.getSelectedIndex() == 1) {
						dtm.setValueAt("DIEN LANH", table.getSelectedRow(), 2);
					}
					if (comboBoxLoaisp.getSelectedIndex() == 2) {
						dtm.setValueAt("DIEN GIA DUNG", table.getSelectedRow(), 2);
					}
					if (comboBoxLoaisp.getSelectedIndex() == 3) {
						dtm.setValueAt("KHAC", table.getSelectedRow(), 2);
					}
				}
			}

		});
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(183, 282, 121, 30);
		frame.getContentPane().add(btnSua);
//XOA
		JButton btnXoa = new JButton("XOA");
		btnXoa.setIcon(
				new ImageIcon("D:\\Project\\bin\\image\\delete.png"));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (table.getSelectedRow() != -1) {
					dtm.removeRow(table.getSelectedRow());
					JOptionPane.showMessageDialog(null, " da xoa thanh cong ");
				}

			}
		});
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(333, 282, 121, 30);
		frame.getContentPane().add(btnXoa);
		
		// Xuat
		JButton btnXuat = new JButton("XUAT FILE");
		// btnTimkiem.setIcon(new ImageIcon("src\\swing\\New folder (2)\\images
		// EXPORT.png"));
		btnXuat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				final String xmlFilePath = "D:\\SanPham.xml";

				try {
					DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
					Document document = documentBuilder.newDocument();

					// root element
					Element root = document.createElement("sanpham");
					document.appendChild(root);

					// Mã Sán Phẩm
					Element maSP = document.createElement("maSP");
					maSP.appendChild(document.createTextNode(" " + table.getValueAt(table.getSelectedRow(), 0)));
					root.appendChild(maSP);

					// Loại Sản Phẩm
					Element loaiSP = document.createElement("loaiSP");
					loaiSP.appendChild(document.createTextNode(" " + table.getValueAt(table.getSelectedRow(), 1)));
					root.appendChild(loaiSP);

					// Tên Sản Phẩm
					Element tenSP = document.createElement("tenSP");
					tenSP.appendChild(document.createTextNode(" " + table.getValueAt(table.getSelectedRow(), 2)));
					root.appendChild(tenSP);

					// Số Lượng
					Element sl = document.createElement("soLuong");
					sl.appendChild(document.createTextNode(" " + table.getValueAt(table.getSelectedRow(), 3)));
					root.appendChild(sl);

					// Đơn giá
					Element gia = document.createElement("donGia");
					gia.appendChild(document.createTextNode(" " + table.getValueAt(table.getSelectedRow(), 4)));
					root.appendChild(gia);

					// Thành tiền
					Element thanhTien = document.createElement("thanhTien");
					thanhTien.appendChild(document.createTextNode(" " + table.getValueAt(table.getSelectedRow(), 5)));
					root.appendChild(thanhTien);

					// create the xml file 
					// transform the DOM Object to an XML File
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();
					transformer.setOutputProperty(OutputKeys.INDENT, "yes");
					DOMSource domSource = new DOMSource(document);
					StreamResult streamResult = new StreamResult(new File(xmlFilePath));
					transformer.transform(domSource, streamResult);
				} catch (ParserConfigurationException pce) {
					pce.printStackTrace();
				} catch (TransformerException tfe) {
					tfe.printStackTrace();
				}

			}

		});
		btnXuat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXuat.setBounds(487, 283, 121, 30);
		frame.getContentPane().add(btnXuat);
		
//THOAT
		JButton btnThoat = new JButton("THOAT");
		btnThoat.setIcon(new ImageIcon("D:\\Project\\bin\\image\\fgyhg.jpg"));
		btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		btnThoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThoat.setBounds(647, 282, 121, 30);
		frame.getContentPane().add(btnThoat);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 345, 746, 275);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(new Object[][] { { null, "", "", "", null, null }, },
				new String[] { "MA SP", "LOAI SP", "TEN SP", "SO LUONG", "DON GIA", "THANH TIEN" }));
		scrollPane.setViewportView(table);
	}
}
