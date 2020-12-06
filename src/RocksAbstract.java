abstract class RocksAbstract {
    protected int amount;

    RocksAbstract(int amount) {
        this.amount = amount;
    }

    public void setRocks(int amount){
        this.amount = amount;
    }

    public int getRocks(){
        return amount;
}
}
