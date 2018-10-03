public class NonPerishable extends Item{
    private float volume;

    NonPerishable(String name){
        super(name);
        this.volume = 0;
    }

    public void setVolume(float volume){
        this.volume = volume;
    }    

    public float getVolume(){
        return this.volume;
    }
}