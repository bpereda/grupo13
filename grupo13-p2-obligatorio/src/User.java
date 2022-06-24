public class User {
    private String username;
    private int cantidad_de_resenias = 0;
    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCantidad_de_resenias() {
        return cantidad_de_resenias;
    }

    public void setCantidad_de_resenias(int cantidad_de_resenias) {
        this.cantidad_de_resenias = cantidad_de_resenias;
    }
}
