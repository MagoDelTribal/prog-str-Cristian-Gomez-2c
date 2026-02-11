public class Main {
    public static void main(String [] args){


        int[] arr;
        int[] arr1=new int [4];
        int[] arr2={1,2,3,4};

        System.out.println(arr1[0]);
        System.out.println(arr1[1]);

        System.out.println("====================================");
        for (int i = 0; i < arr1.length ; i++) {
            System.out.println(arr1[1]);
        }
        System.out.println("=====================================");
        for(int numero : arr1){
            System.out.println(numero);
        }

        System.out.println("==============================");
        persona[] personas=new persona[3];
        persona persona1=new persona();
        persona1.setId(1);
        persona1.setName("test");
        persona1.setActivo(true);
        persona persona2=new persona(2,"Cristian");
        persona persona3=new persona(3,"Eduardo");
        personas[0]=persona1;
        personas[1]=persona2;
        personas[2]=persona3;

        personas[0]=null;//eliminarc el primer elemento

        for (persona persona:personas){
            System.out.println("_______________________________");
            //System.out.println(persona);
            try{
                System.out.println("_______________________________");
                System.out.println(persona.getId());
                System.out.println(persona.getName());
                System.out.println(persona.isActivo());
            }catch (Exception e){
                System.out.println("hay un null");
            }
        }



    }
}