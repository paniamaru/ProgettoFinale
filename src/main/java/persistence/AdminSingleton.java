package persistence;

import model.Admin;

public class  AdminSingleton {
		private Admin user;
		private final static AdminSingleton INSTANCE = new AdminSingleton();
		private AdminSingleton() {}
		
		public static AdminSingleton getInstance() {
			return INSTANCE;
		}
		
		public boolean setAdmin(Admin u) {
			try {
				this.user= u;
				return true;
			} catch (Exception e) {
				System.out.println("Errore creazione utente singleton: "+ e.getMessage());
				return false;
			}
		}
		
		public Admin getAdmin() {
			return this.user;
		}	
}