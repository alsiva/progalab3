abstract class RocksAbstract {
    private int amount;

    RocksAbstract(int n) {
        this.amount = n;
    }

    public void setRocks(int n){
        this.amount = n;
    }

    public int getRocks(){
        return amount;
}
}
