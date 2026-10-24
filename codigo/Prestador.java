public class Prestador {

    private String PrestadorId;
    private String NomePrestador;

    private float ValorHora;
    private int horasContratadas;

    private String[] categorias = new String[0];

    private static int contador = 0;

    private static final String[] categorias_disponiveis = {
            "Elétrica",
            "Hidráulica",
            "Pintura",
            "Alvenaria",
            "Limpeza",
            "Jardinagem",
            "Marcenaria",
            "Montagem de móveis"
    };

    // PRIMEIRA PARTE AQI VAI FICAR O TRATAMENTO DO ID DO PRESTADOR PRF REVISEM E VEJAM SE TEM MAIS COISAS PARA FAZER AQI
    public Prestador(){
        this.PrestadorId = gerarIdPrestador();
    }

    private static String gerarIdPrestador(){
        if(contador > 99999){
            throw new IllegalArgumentException("Todos os codigos ja foram utilizados");
        }

        int Contador = 0;
        String numero = "" + contador;
        String codigo = "PR";

        for(int i = numero.length(); i < 3; i++){
            codigo += 0;
        }

        codigo += numero;
        contador++;

        return codigo;
    }

    public String getPrestadorId(){
        return this.PrestadorId;
    } // AQI FECHAM

    // COMEÇAMOS COM NOME AGR

    public void setNomePrestador(String nomePrestador) {
        if (nomePrestador == null) {
            throw new IllegalArgumentException("O nome do prestador não pode ser nulo");
        }
        if (nomePrestador.length() == 0){
            throw new IllegalArgumentException("O nome do prestador não pode ficar vazio");
        }

        this.NomePrestador = nomePrestador.trim(); //glr esse .trim é para tratar espaço tipo " matheus " fica "matheus" tenderam
    }

    public String getNomePrestador() {
        return this.NomePrestador;
    }
    //aqi fechamos o nome

    //vamos com o valor agr, usei float por conta que vamos economizar memoria

    //usei uma base de no min 50 conto a hora ate no max 500 para n ter coisa absurda

    public void setValorHora(int valorHora){
        if(valorHora < 50 || valorHora > 1000){
            throw new IllegalArgumentException("O valor por hora deve ser pelo menos R$ 50 a sua hora ou no maximo R$1000 a hora");
        }
        this.ValorHora = valorHora;
    }

    public float getValorHora(){
        return this.ValorHora;
    }

    //agr vamos validar as horas contratadas  e minutos pq se ele trabalhar entre 0 e 59 mins independete vai ser a hora de 50mins

    public void setHorasContratadas(int horas, int minutos){

        if(horas < 0){
            throw new IllegalArgumentException("As horas não podem ser negativas");
        }

        if(minutos < 0 || minutos > 59){
            throw new IllegalArgumentException("Os minutos devem estar entre 0 e 59");
        }

        int horasCobradas = horas;

        if(minutos > 0){
            horasCobradas++;
        }

        //cobrança minima de uma hora
        if(horasCobradas == 0){
            horasCobradas = 1;
        }

        this.horasContratadas = horasCobradas;
    }

    public int getHorasContratadas(){
        return this.horasContratadas;
    }

    // calculo do contrato

    public float calcularTotalContrato(){

        if(this.ValorHora < 50 || this.ValorHora > 1000){
            throw new IllegalStateException("Defina um valor por hora válido antes de calcular");
        }

        if(this.horasContratadas < 1){
            throw new IllegalStateException("Defina as horas contratadas antes de calcular");
        }

        return this.ValorHora * this.horasContratadas;
    }

    //categorias dos prestador

    public void SetCategorias(String[] categorias){

        if(categorias == null || categorias.length == 0){
            throw new IllegalArgumentException("A Categoria nao pode ser vazia nem nula");
        }
        if(categorias.length < 1 || categorias.length > 4){
            throw new IllegalArgumentException("O Prestador deve ter entre 1 a 4 categorias");
        }

        String[] categoriasValidadas = new String[categorias.length];

        for(int i = 0; i < categorias.length; i++){

            if(categorias[i] == null){
                throw new IllegalArgumentException("A categoria não pode ser nula");
            }

            String categoria = categorias[i].trim();

            if(categoria.length() == 0){
                throw new IllegalArgumentException("A Categoria não pode ser ficar vazia");
            }
            //ve se a categoria ja foi informada
            for(int j = 0; j < i; j++){

                if(categoria.equals(categoriasValidadas[j])){
                    throw new IllegalArgumentException("Categoria repetida" + categoria);
                }
            }
            categoriasValidadas[i] = categoria;
        }

        this.categorias = categoriasValidadas;
    }

    public String[] getCategorias(){
        return this.categorias.clone();
    }
}