import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<User> users = new ArrayList<>();
    static User user;
    static ArrayList<Jam> jam = new ArrayList<>();

    public static void main(String[] args) {
        users.add(new User("Ucup", "ucup", "123"));
        users.add(new User("Ujang", "ujang", "123"));
        users.add(new User("Sopian", "sopian", "123"));
       
        menuUtama();
    }

    static void menuDalam() {
        System.out.println("Selamat Datang, " + user.getNama());
        int x = 0;
        while(x != 4) {
            tampil();
            System.out.println("1. Tambah Jam\n2. Hapus Jam\n3. Update Stok\n4. Logout");
            System.out.print(">> "); x = Integer.valueOf(sc.nextLine());
            if(x == 1) {
                tambah();
            }else if(x == 2) {
                hapus();
            }else if(x == 3) {
                UpdateStok();
            }else if(x == 4) {
                return;
            }else  {

            }
        }
    }

    static void menuUtama() {
        int p = 0;
        while(p != 3) {
            System.out.println("*** TOKO JAM TANGAN***");
            System.out.println("1. Login\n2. List Jam Tangan\n3. Exit");
            System.out.print(">> ");
            p = Integer.valueOf(sc.nextLine());
            if(p == 1) {
                if(login()) {
                    menuDalam();
                }else {
                    System.out.println("Login Gagal!");
                }
            }else if(p == 2) {
                tampil();
            }else if(p == 3) {
                System.exit(0);
            }else {
                System.out.println("Input Error!");
                p = 0;
            }
        }
    }

    static void UpdateStok() {
        tampil();
        System.out.println("---Update Stok---");
        System.out.print("No Jam: ");
        int no = Integer.valueOf(sc.nextLine());
        System.out.print("Jumlah Stok: ");
        int jb = Integer.valueOf(sc.nextLine());
        jam.get(no-1).UpdateStok(jb);
    }

    static void hapus() {
        tampil();
        System.out.println("---Hapus Jam---");
        System.out.print("No Jam: ");
        int no = Integer.valueOf(sc.nextLine());
        try {
            jam.remove(no - 1);
            System.out.println("Jam Berhasil Dihapus!");
        }catch(Exception e) {
            System.out.println("Jam Gagal Dihapus!");
        }
    }

    static void tambah() {
        System.out.println("---Tambah Jam---");
        System.out.print("Type: ");
        String type = sc.nextLine();
        System.out.println("Merk:\n\t1. Casio\n\t2. Fossil\n\t3. G-shock");
        System.out.print(">> ");
        int merk = Integer.valueOf(sc.nextLine());
        System.out.print("Harga: ");
        int price = Integer.valueOf(sc.nextLine());
        System.out.print("Stok : ");
        int stock = Integer.valueOf(sc.nextLine());
        if(merk == 1) {
            jam.add(new Casio(type, price, stock));
        }else if(merk == 2) {
            jam.add(new Fossil(type, price, stock));
        }else if(merk == 3) {
            jam.add(new G_shock(type, price, stock));
        }
        System.out.println("Tambah Berhasil!");
    }

    static boolean login() {
        System.out.println("---Login---");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        for (User u: users) {
            if(u.getUsername().equalsIgnoreCase(username) && u.getPassword().equalsIgnoreCase(password)) {
                user = u;
                return true;
            }
        }
        return false;
    }

    static void tampil() {
        int i = 0;
        System.out.println("\n---List Jam Tangan---");
        for (Jam j: jam) {
            System.out.println(++i + ". " + j.getType() + " - " + j.getMerk() + " - " + j.getPrice() + " Stock: " + j.getStock());
        }
        System.out.println("\n");
    }




}
