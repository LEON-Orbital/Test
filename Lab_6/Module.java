public class Module extends KeyableMap<String,String,Assessment> {

    public Module(String modName) {
        super(modName);
    }

    @Override
    public Module put(Assessment ass) {
        this.map.put(ass.getKey(), ass);
        return (Module) this;
    }
}


