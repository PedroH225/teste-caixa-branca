package main;

import login.User;

public class Main {
	public static void main(String[] args) {
		System.out.println(new User().verificarUsuario("maria", "senha123"));
	}
}
