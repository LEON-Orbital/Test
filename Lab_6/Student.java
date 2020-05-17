public class Student extends KeyableMap<String,String,Module> {

    public Student(String studentName) {
        super(studentName);
    }

    @Override
    public Student put(Module mod) {
        this.map.put(mod.getKey(), mod);
        return (Student) this;
    }
}

