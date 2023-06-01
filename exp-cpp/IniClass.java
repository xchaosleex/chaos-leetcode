class IniClass {

    int a;
    int b;

    public IniClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        IniClass iniClass = new IniClass(1, 0);
        System.out.println(iniClass);
        System.out.println(iniClass.a);
        System.out.println(iniClass.b);
    }
}
