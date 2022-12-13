public class Jam {
    private String type;
    private String merk;
    private int price, stock;

    public Jam(String type, String merk, int price, int stock) {
        this.type = type;
        this.merk = merk;
        this.price = price;
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public String getMerk() {
        return merk;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void UpdateStok(int jb) {
        this.stock -= jb;
        System.out.println("***MEMBELI***");
        System.out.println("\tType: " + this.getType());
        System.out.println("\tMerk: " + this.getMerk());
        System.out.println("\tHarga Satuan: " + this.getPrice());
        System.out.println("\tJumlah Beli: " + jb);
        System.out.println("\tTotal Harga: " + this.getPrice() * jb);
    }
}
