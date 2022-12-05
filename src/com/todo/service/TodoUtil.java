package com.todo.service;

import java.util.*;
import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		
		String title, desc;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[�׸� �߰�]\n" 
				+ "���� > ");
		
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.println("������ �ߺ��˴ϴ�!");
			return;
		}
		sc.nextLine();
		System.out.print("���� > ");
		desc = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, desc);
		list.addItem(t);
		System.out.println("�߰��Ǿ����ϴ�.");
	}
	
	public static void deleteItem(TodoList l) {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[�׸� ����]\n"
				+ "������ �׸��� ������ �Է��Ͻÿ� > ");
		String title = sc.next();
		
		for (TodoItem item : l.getList()) {
		if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				System.out.println("�����Ǿ����ϴ�.");
				break;
			}
		}
	}
	
	
	public static void updateItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[�׸� ����]\n"
				+ "������ �׸��� ������ �Է��Ͻÿ� > ");
		String title = sc.next().trim();
		if (!l.isDuplicate(title)) {
			System.out.println("���� �����Դϴ�!");
			return;
		}
		//�ߺ��Ǵ� ������ �ִٸ�
		System.out.print("�� ���� > ");
		String new_title = sc.next().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("������ �ߺ��˴ϴ�!");
			return;
		}
		sc.nextLine();
		System.out.print("�� ���� > ");
		String new_description = sc.nextLine().trim();
		for(TodoItem item :l.getList()) {
			if (item.getTitle().equals(title)) {//���� ���� ���� ���� ã��
				l.deleteItem(item); //���� ���� ���� ����
				TodoItem t = new TodoItem(new_title, new_description); //���ο� ����, ���� ����
				l.addItem(t);
				System.out.println("�����Ǿ����ϴ�.");
			} //������ ��� curren_date�� ������
		}
	}
	
	public static void listAll(TodoList l) {
		System.out.println("[��ü ���]");
			for (TodoItem item : l.getList()) {
				System.out.println(item.toString());
		}
	}
}