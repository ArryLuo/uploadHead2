package com.hpsvse.customer.web.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.hpsvse.customer.entity.Users;

public class UsersAction {

	private File[] head;
	private String[] headFileName;
	private String[] headContentType;

	private Users users;

	public String upload() {
		if (head != null) {
			if (users == null) {
				users = new Users();

			}
			users.setHead(new String[head.length]);
			for (int i = 0; i < head.length; i++) {
				// 求出文件的扩展名
				String extname = headFileName[i].substring(headFileName[i]
						.lastIndexOf("."));
				String newName = System.currentTimeMillis() + extname;

				File target = new File(ServletActionContext.getServletContext()
						.getRealPath("/upload"), newName);
				try {
					FileUtils.copyFile(head[i], target);

					users.getHead()[i] = newName;

					xiaotu(head[i], newName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

		return "success";
	}

	private void xiaotu(File head, String newName) {
		BufferedImage bufimage = new BufferedImage(200, 200,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = bufimage.getGraphics();

		InputStream is;
		try {
			is = new FileInputStream(head);
			BufferedImage bi = ImageIO.read(is);
			Image im = (Image) bi;

			g.drawImage(im, 0, 0, 200, 200, null);
			g.setFont(new Font("黑体", Font.BOLD, 30));
			g.setColor(Color.WHITE);
			g.drawString("J1666版本所有", 100, 150);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		g.dispose();

		File target = new File(ServletActionContext.getServletContext()
				.getRealPath("/upload"), "small_" + newName);

		try {
			ImageIO.write(bufimage, "png", target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public File[] getHead() {
		return head;
	}

	public void setHead(File[] head) {
		this.head = head;
	}

	public String[] getHeadFileName() {
		return headFileName;
	}

	public void setHeadFileName(String[] headFileName) {
		this.headFileName = headFileName;
	}

	public String[] getHeadContentType() {
		return headContentType;
	}

	public void setHeadContentType(String[] headContentType) {
		this.headContentType = headContentType;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
