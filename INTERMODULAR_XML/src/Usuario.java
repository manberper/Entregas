public class Usuario {
    int idUsuario; // PK se debe validar como unico
    String nombre; // Varchar 32
    String mail; // Varchar 64
    String fRegistro; // tipo DATE se debe validar

    public Usuario(int idUsuario, String nombre, String mail, String fRegistro) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.mail = mail;
        this.fRegistro = fRegistro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getfRegistro() {
        return fRegistro;
    }

    public void setfRegistro(String fRegistro) {
        this.fRegistro = fRegistro;
    }

    public String aXml() {
        return  "\n <Usuario>" +
                "\n     <idUsuario>" + idUsuario + "</idUsuario>" +
                "\n     <nombre>" + nombre + "</nombre>" +
                "\n     <mail>" + mail + "</mail>" +
                "\n     <fRegistro>" + fRegistro + "</fRegistro>" +
                "\n </Usuario>";
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", fRegistro='" + fRegistro + '\'' +
                '}';
    }
}
