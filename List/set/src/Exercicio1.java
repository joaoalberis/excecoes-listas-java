import java.util.*;

public class Exercicio1 {
    public static void main(String[] args) {

        //Ordem de inserção
        Set<LinguagemFavorita> linguagens = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("JS", 2000, "VS Code"));
            add(new LinguagemFavorita("Java", 1990, "Intellij"));
            add(new LinguagemFavorita("Python", 2005, "PyCharm"));
        }};
        System.out.println(linguagens);

        //Oderm Natural(Nome)
        Set<LinguagemFavorita> linguagens2 = new TreeSet<>(linguagens);
        System.out.println(linguagens2);

        //Ordem IDE
        Set<LinguagemFavorita> linguagens3 = new TreeSet<>(new CompatorIde());
        linguagens3.addAll(linguagens2);
        System.out.println(linguagens3);


        //Ordem Ano de criação/Nome
        Set<LinguagemFavorita> linguagens4 = new TreeSet<>(new ComparatorAnoCriacaoNome());
        linguagens4.addAll(linguagens3);
        System.out.println(linguagens4);

        //Ordem Nome/Ano/IDE
        Set<LinguagemFavorita> linguagens5 = new TreeSet<>(new ComparatorNomeAnoCriacaoIde());
        linguagens5.addAll(linguagens4);
        System.out.println(linguagens5);
    }
}

class CompatorIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}

class ComparatorAnoCriacaoNome implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int ano = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if (ano != 0) return ano;
        return o1.getNome().compareToIgnoreCase(o2.getNome());
    }
}

class ComparatorNomeAnoCriacaoIde implements Comparator<LinguagemFavorita>{

    @Override
    public int compare(LinguagemFavorita o1, LinguagemFavorita o2) {
        int nome = o1.getNome().compareToIgnoreCase(o2.getNome());
        if (nome != 0) return nome;
        int ano = Integer.compare(o1.getAnoDeCriacao(), o2.getAnoDeCriacao());
        if (ano != 0) return ano;
        return o1.getIde().compareToIgnoreCase(o2.getIde());
    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {
    String nome;
    Integer anoDeCriacao;
    String ide;

    public LinguagemFavorita(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", anoDeCriacao=" + anoDeCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(Integer anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }


    @Override
    public int compareTo(LinguagemFavorita o) {
        return this.getNome().compareToIgnoreCase(o.getNome());
    }
}
