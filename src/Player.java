/**
 * Jogador
 */
public class Player {

    private String name; // Nome do jogador

    /**
     * Retorna o nome do jogador
     * 
     * @return String nome do jogador.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Define o home do jogador
     * 
     * @param name String contendo o nome do jogador.
     */
    public void setName(String name) {
        this.name = name;
    }
}
