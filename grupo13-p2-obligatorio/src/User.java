public class User implements Comparable<User>{
    private String username;
    int cantidad_de_resenias = 0;

    public int getCantidad_de_resenias() {
        return cantidad_de_resenias;
    }

    public void setCantidad_de_resenias(int cantidad_de_resenias) {
        this.cantidad_de_resenias = cantidad_de_resenias;
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int compareTo(User o) {
        if(this.getCantidad_de_resenias()>o.getCantidad_de_resenias())
        {
            return 1;
        }else if(this.getCantidad_de_resenias()==o.getCantidad_de_resenias())
        {
            return 0;
        }else
        {
            return -1;
        }
    }
}
