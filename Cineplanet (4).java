import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Producto {
    String nombre;
    double precioUnitario;
    String butaca;
    int cantidad;

    public Producto(String nombre, double precioUnitario, String butaca, int cantidad) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.butaca = butaca;
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioUnitario * cantidad;
    }
}

public class Cineplanet {

    static ArrayList<Producto> carrito = new ArrayList<>();
    static ArrayList<String> categorias = new ArrayList<>();
    static ArrayList<String> peliculas2d = new ArrayList<>();
    static ArrayList<Producto> unperroespecial = new ArrayList<>();
    static ArrayList<Producto> laconfecion = new ArrayList<>();
    static ArrayList<Producto> lasustancia = new ArrayList<>();
    static ArrayList<Producto> robodsalvaje = new ArrayList<>();
    static String[][] mapaButaca = new String[10][15];
    static ArrayList<Producto> canchita = new ArrayList<>();
    static ArrayList<Producto> bebidas = new ArrayList<>();
    static ArrayList<Producto> combo = new ArrayList<>();
    static ArrayList<String> fechas = new ArrayList<>();
    static ArrayList<String> datosSolicitudes = new ArrayList<>();
    static String empresa, contacto, correo, nombre, capacidad, peliculaSeleccionada;
    static int dni, numero, dia, mes, año;

    static Scanner luffy = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarMapaButacas();

        categorias.add("Peliculas");
        categorias.add("dulceria ");
        categorias.add("corporativo");

        peliculas2d.add("Un perro especial 1 horas 53 minutos");
        unperroespecial.add(new Producto("Un perro especial general", 18, "", 0));
        unperroespecial.add(new Producto("Un perro especial niño", 15, "", 0));

        peliculas2d.add("La confesion de diablo 2 horas  ");
        laconfecion.add(new Producto("La confesion de diablo general", 25.50, "", 0));
        laconfecion.add(new Producto("La confesion de diablo  niños", 23.50, "", 0));

        peliculas2d.add("la sustancia 2 horas 30 minutos ");
        lasustancia.add(new Producto("la sustancia general : ", 34, "", 0));
        lasustancia.add(new Producto("la sustancia niño", 30, "", 0));

        peliculas2d.add("Robod salvaje 2 horas ");
        robodsalvaje.add(new Producto("robod salbaje general ", 25.50,"",0));
        robodsalvaje.add(new Producto("robod salbaje niño ", 23.50,"",0));

        combo.add(new Producto("COMBO - canchita gigante salada + 4 bebidas ", 47.00, "", 0));
        combo.add(new Producto("COMBO - canchita gigante dulce + 4 bebidas ", 51.00, "", 0));



        canchita.add(new Producto("canchita gigante  dulce", 24.50, "", 0));
        canchita.add(new Producto("canchita gigante  salada", 20.50, "", 0));
        canchita.add(new Producto("canchita mediana dulce", 14.00, "", 0));
        canchita.add(new Producto("canchita mediana salada", 12.00, "", 0));


        bebidas.add(new Producto("Coca cola mediana", 10.50, "", 0));
        bebidas.add(new Producto("Cpca cola grande ", 12.00, "", 1));
        bebidas.add(new Producto("Agua san luis sin gas ", 4.00, "", 1));

        System.out.println("""
                🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞
                🎞🎞                       Bienvenido a  "CinePlanet"                      🎞🎞
                🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞🎞
                """);


        tipoDePelicula();
    }

    public static void tipoDePelicula() {

        System.out.println("""
                                           ;coxO000kxolc;
                                           :oOXWWXOdlc;
                                         :kXWWXkl;
                                       ;xNMWXx:
                                      c0WMWO:                          :oc                       :ooc                                        okxc                                     :dkd:
                                     cKMMNx;                         ;dXW0cll                    :ooc                                        okxc                                     :dkd:
                                    :OWMWk;     ;:ll:            :oOKOk0KOOKO:                                                              :0MWx                                     oNMXl
                                    dNMMKc    o0XNWWKl      ;:: lKWMW0ccONNk:          :dkOOkxc  ckOd; ;oxkkkkxxl;    :dkOOko:  :dk00KK0kl  :0MWx   :dkckxxkx: :dkkkkkxl;    cdkOOko;  oXMW0kcc
                                    kWMWk     xWMMMWXd   ldOKNXxcdOkl; ;dOo;          oKWWXKXKd  dWMKc dNMWKKNWWW0c  oXWN0OXWKl oNMWKO0NMNx;:0MWx   ddcxkxkxx:xWMWKKNWW0c ;xNWN00NW0c oXMWKOll
                                   ;OMMWx     ;dOOOOOkd:cKMMMWXk:                    cKMWOc;;;   dWMKc dNMKc lxKMWk cKMWK  0WMk;oNMNd ;xWMKc:0MWk        WWWO:xWMKc lKMWx;oXMWK  KWWx oXMXl
                                    kWMWx;:ccc; dKNWMMW0clOOkkkkko    ;od:           lXMWx       dWMKc dWM0: :lOMMO;lXMWX0000Ol oNMNo  xWMXl:0MWk;oKWN0SKWMXo;xWMKc :OMWO:dNMWX0000kc oXMKl
                           ;dko    c0WMWKOXNWW0clKWWNXKOl  o0NWMW0c :xKWNd           ;OWMXkxxko  dWMKc dWM0: :lOMMO;:0WWK     ; oNMWKkONMNx;:0MWk:xWMK   NMXo;kWMKc :OMWO;cKMWK       oXMKl
                            :kOl   :kXWMXkOKKKOl :dO000KKOloKNKkd:  lKN0o;            :xKNNNNXx; c0NO: oXNO: ;ckNNk; ckKXNNNXk: oNMWNXXKOo; ;dXXd;ckKXXXNNXkc;xXNO: ;kNNx; lkKNNNNKx; cON0c
                            ;oO0kkOkdkNMW0loO000kcc0WMMMWXx;;:;      ::                 ;:cc:;    ;:;  ;:c:    :cc;    ;:ccc:   oNMNd;;;      ::;   ;:clcc;   ;cc:   :cc;    ;cccc;    ;c:
                         ;:cloxkxxk00xx0WW0dkXXXXx:cxO0000Oxc                                                                   lKWXo
                       :coddxxxdl::dO0kx0WWKdc::;;   oKNWMWNk;     ;;                                                            coo:
                    ;:loxxxxdol:;   :colldk0X0d:     ;okkxol:   ;;;
                    codxxxddoc:;           ;lxOOkdlc;;   ;;::::;;
                    oddddoolc:;;            :clooollccccc::;
                    oooolllcc
                    olllccc
                    \n
                    """);




        System.out.println("Seleccione una opcion:");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " + categorias.get(i));
        }
        System.out.println((categorias.size() + 1) + ". salir");

        int opcion = pedirOpcion(categorias.size() + 1);

        if (opcion == categorias.size() + 1) {
            System.out.println("saliendo de cineplanet");
            System.exit(0);
        } else if (opcion == 1) {
            peliculas2D();
        } else if (opcion == 2) {
            agregarDulces();
        } else if (opcion == 3) {
            mostrarCorporativo();
        }
    }

    public static void peliculas2D() {
        System.out.println("\n----------------------------------- Películas 2D -----------------------------------");
        System.out.println("Seleccione una película:");

        for (int i = 0; i < peliculas2d.size(); i++) {
            System.out.println((i + 1) + ". " + peliculas2d.get(i));
        }
        System.out.println(peliculas2d.size() + 1 + ". Regresar");

        int opcion = pedirOpcion(peliculas2d.size() + 1);

        if (opcion == peliculas2d.size() + 1) {
            tipoDePelicula();
        } else {
            manejarSubcategoriaAudio(opcion);
        }
    }

    public static void manejarSubcategoriaAudio(int opcion) {
        if (opcion == 1) {
            System.out.println("Tenemos los siguientes precios para :");
            System.out.println("=====================================================");
            edadpelicula1("Titanic");
        } else if (opcion == 2) {
            System.out.println("Tenemos los siguientes precios para :");
            System.out.println("=====================================================");
            edadpelicula2("Thanos");
        } else if (opcion == 3) {
            System.out.println("Tenemos los siguientes precios para :");
            System.out.println("=====================================================");
            edadpelicula3("Lufi");
        } else if (opcion==4) {
            System.out.println("Tenemos los siguientes precios para :");
            System.out.println("=====================================================");
            edadpelicula4("Lufi");
        }
    }
    public static void edadpelicula1(String pelicula) {
        System.out.println("Seleccione un modelo de su tipo de pelicula:");
        System.out.println("=====================================================");

        for (int i = 0; i < unperroespecial.size(); i++) {
            Producto producto = unperroespecial.get(i);
            System.out.println((i + 1) + ". " + producto.nombre + " - S/. " + producto.precioUnitario);
        }

        System.out.println((unperroespecial.size() + 1) + ". Regresar");
        int opcion = pedirOpcion(unperroespecial.size() + 1);

        if (opcion == unperroespecial.size() + 1) {
            tipoDePelicula();
        } else {
            Producto productoSeleccionado = unperroespecial.get(opcion - 1);

            int cantidad = 0;
            boolean cantidadValida = false;
            while (!cantidadValida) {
                System.out.print("¿Cuántas unidades deseas comprar? ");
                cantidad = luffy.nextInt();
                if (cantidad > 0) {
                    cantidadValida = true;
                } else {
                    System.out.println("Por favor ingresa un número positivo de unidades.");
                }
            }


            for (int i = 0; i < cantidad; i++) {

                String butaca = seleccionarButaca(pelicula);
                if (butaca != null) {

                    carrito.add(new Producto("Butaca para " + productoSeleccionado.nombre + " - " + butaca, productoSeleccionado.precioUnitario, butaca, 1));
                } else {
                    System.out.println("Lo siento, no hay más butacas disponibles para esta película.");
                }
            }

            mostrarCarrito();

            System.out.println("¿Desea agregar más asientos? (1. Sí / 2. No)");
            int respuesta = pedirOpcion(2);

            if (respuesta == 1) {
                tipoDePelicula();
            } else {
                opcionesPago();
            }
        }
    }
    public static void edadpelicula2(String pelicula) {
        System.out.println("Seleccione un modelo de su tipo de pelicula:");
        System.out.println("=====================================================");

        for (int i = 0; i < laconfecion.size(); i++) {
            Producto producto = laconfecion.get(i);
            System.out.println((i + 1) + ". " + producto.nombre + " - S/. " + producto.precioUnitario);
        }

        System.out.println((laconfecion.size() + 1) + ". Regresar");
        int opcion = pedirOpcion(laconfecion.size() + 1);

        if (opcion == laconfecion.size() + 1) {
            tipoDePelicula();
        } else {
            Producto productoSeleccionado = laconfecion.get(opcion - 1);

            int cantidad = 0;
            boolean cantidadValida = false;
            while (!cantidadValida) {
                System.out.print("¿Cuántas unidades deseas comprar? ");
                cantidad = luffy.nextInt();
                if (cantidad > 0) {
                    cantidadValida = true;
                } else {
                    System.out.println("Por favor ingresa un número positivo de unidades.");
                }
            }


            for (int i = 0; i < cantidad; i++) {

                String butaca = seleccionarButaca(pelicula);
                if (butaca != null) {

                    carrito.add(new Producto("Butaca para " + productoSeleccionado.nombre + " - " + butaca, productoSeleccionado.precioUnitario, butaca, 1));
                } else {
                    System.out.println("Lo siento, no hay más butacas disponibles para esta película.");
                }
            }

            mostrarCarrito();

            System.out.println("¿Desea agregar más asientos? (1. Sí / 2. No)");
            int respuesta = pedirOpcion(2);

            if (respuesta == 1) {
                tipoDePelicula();
            } else {
                opcionesPago();
            }
        }
    }

    public static void edadpelicula3(String pelicula) {
        System.out.println("Seleccione un modelo de su tipo de pelicula:");
        System.out.println("=====================================================");

        for (int i = 0; i < lasustancia.size(); i++) {
            Producto producto = lasustancia.get(i);
            System.out.println((i + 1) + ". " + producto.nombre + " - S/. " + producto.precioUnitario);
        }

        System.out.println((lasustancia.size() + 1) + ". Regresar");
        int opcion = pedirOpcion(lasustancia.size() + 1);

        if (opcion == lasustancia.size() + 1) {
            tipoDePelicula();
        } else {
            Producto productoSeleccionado = lasustancia.get(opcion - 1);

            int cantidad = 0;
            boolean cantidadValida = false;
            while (!cantidadValida) {
                System.out.print("¿Cuántas unidades deseas comprar? ");
                cantidad = luffy.nextInt();
                if (cantidad > 0) {
                    cantidadValida = true;
                } else {
                    System.out.println("Por favor ingresa un número positivo de unidades.");
                }
            }


            for (int i = 0; i < cantidad; i++) {

                String butaca = seleccionarButaca(pelicula);
                if (butaca != null) {

                    carrito.add(new Producto("Butaca para " + productoSeleccionado.nombre + " - " + butaca, productoSeleccionado.precioUnitario, butaca, 1));
                } else {
                    System.out.println("Lo siento, no hay más butacas disponibles para esta película.");
                }
            }

            mostrarCarrito();

            System.out.println("¿Desea agregar más asientos? (1. Sí / 2. No)");
            int respuesta = pedirOpcion(2);

            if (respuesta == 1) {
                tipoDePelicula();
            } else {
                opcionesPago();
            }
        }
    }
    public static void edadpelicula4(String pelicula) {
        System.out.println("Seleccione un modelo de su tipo de pelicula:");
        System.out.println("=====================================================");

        for (int i = 0; i < robodsalvaje.size(); i++) {
            Producto producto = robodsalvaje.get(i);
            System.out.println((i + 1) + ". " + producto.nombre + " - S/. " + producto.precioUnitario);
        }

        System.out.println((robodsalvaje.size() + 1) + ". Regresar");
        int opcion = pedirOpcion(robodsalvaje.size() + 1);

        if (opcion == robodsalvaje.size() + 1) {
            tipoDePelicula();
        } else {
            Producto productoSeleccionado = robodsalvaje.get(opcion - 1);

            int cantidad = 0;
            boolean cantidadValida = false;
            while (!cantidadValida) {
                System.out.print("¿Cuántas unidades deseas comprar? ");
                cantidad = luffy.nextInt();
                if (cantidad > 0) {
                    cantidadValida = true;
                } else {
                    System.out.println("Por favor ingresa un número positivo de unidades.");
                }
            }


            for (int i = 0; i < cantidad; i++) {

                String butaca = seleccionarButaca(pelicula);
                if (butaca != null) {

                    carrito.add(new Producto("Butaca para " + productoSeleccionado.nombre + " - " + butaca, productoSeleccionado.precioUnitario, butaca, 1));
                } else {
                    System.out.println("Lo siento, no hay más butacas disponibles para esta película.");
                }
            }

            mostrarCarrito();

            System.out.println("¿Desea agregar más asientos? (1. Sí / 2. No)");
            int respuesta = pedirOpcion(2);

            if (respuesta == 1) {
                tipoDePelicula();
            } else {
                opcionesPago();
            }
        }
    }

    public static String seleccionarButaca(String producto) {
        mostrarMapaButacas();
        System.out.println("\nSeleccione una butaca para " + producto + ":");
        Scanner scanner = new Scanner(System.in);
        String butacaSeleccionada;

        while (true) {
            System.out.print("Ingrese el asiento Ejemplo: A1, B3. C5: ");
            butacaSeleccionada = scanner.next().toUpperCase();
            if (validarButaca(butacaSeleccionada)) {
                marcarButacaComoOcupada(butacaSeleccionada);
                break;
            } else {
                System.out.println("La butaca no está disponible o es inválida. Intente de nuevo.");
            }
        }
        return butacaSeleccionada;
    }

    public static boolean validarButaca(String butaca) {
        if (butaca.length() < 2) return false;
        char fila = butaca.charAt(0);
        int columna = Integer.parseInt(butaca.substring(1)) - 1;

        if (fila < 'A' || fila > 'J' || columna < 0 || columna > 14) {
            return false;
        }

        int filaIndex = fila - 'A';
        return mapaButaca[filaIndex][columna].equals("○");
    }

    public static void marcarButacaComoOcupada(String butaca) {
        char fila = butaca.charAt(0);
        int columna = Integer.parseInt(butaca.substring(1)) - 1;

        int filaIndex = fila - 'A';
        mapaButaca[filaIndex][columna] = "X";

        mostrarMapaButacas();
    }

    public static void mostrarMapaButacas() {
        System.out.println("\nMapa de Butacas:");
        System.out.println("     1  2  3  4  5  6  7  8  9 10 11 12 13 14 15");
        for (int i = 0; i < mapaButaca.length; i++) {
            System.out.print((char) ('A' + i) + "   ");
            for (int j = 0; j < mapaButaca[i].length; j++) {
                System.out.print(mapaButaca[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int pedirOpcion(int maxOpcion) {
        int opcion;
        while (true) {
            try {
                opcion = Integer.parseInt(luffy.nextLine());
                if (opcion < 1 || opcion > maxOpcion) {
                    System.out.println("Opción inválida, intente nuevamente.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }
        return opcion;
    }

    public static void opcionesPago() {
        System.out.println("¿Desea proceder con el pago?");
        System.out.println("1. Sí, proceder con el pago.");
        System.out.println("2. Agregar dulces.");

        int opcion = pedirOpcion(2);
        if (opcion == 1) {
            pedirdatoscompra();
        } else {
            agregarDulces();
        }
    }


    public static void agregarDulces() {
        System.out.println("Elija el tipo de combo que desea Adqiuirir:");
        System.out.println("1. combos");
        System.out.println("2. canchita");
        System.out.println("3. bebidas");
        System.out.println("4. Regresar");

        int opcionCombo = pedirOpcion(4);

        switch (opcionCombo) {
            case 1:
                agregarcombo();
                break;
            case 2:
                agregarcanchita();
                break;
            case 3:
                agregarbebidas();
                break;
            case 4:
                tipoDePelicula();
                break;
            default:
                System.out.println("intenta nuevamente");
                agregarDulces();
                break;
        }
    }

    public static void agregarcombo() {
        System.out.println("\nElija un Combo Familiar:");
        for (int i = 0; i < combo.size(); i++) {
            Producto combo = Cineplanet.combo.get(i);
            System.out.println((i + 1) + ". " + combo.nombre + " - S/ " + combo.precioUnitario + " (" + combo.butaca + ")");
        }
        System.out.println((combo.size() + 1) + ". Regresar");

        int opcion = pedirOpcion(combo.size() + 1);

        if (opcion == combo.size() + 1) {
            agregarDulces();

        } else {
            Producto comboSeleccionado = combo.get(opcion - 1);
            System.out.println("¿Cuántos " + comboSeleccionado.nombre + " desea?");
            int cantidad = pedirCantidad();
            carrito.add(new Producto(comboSeleccionado.nombre, comboSeleccionado.precioUnitario, comboSeleccionado.butaca, cantidad));
            System.out.println(cantidad + " " + comboSeleccionado.nombre + " agregados a su carrito.");
            pedirdatoscompra();

        }
    }

    public static void agregarcanchita() {
        System.out.println("\nElija un Combo Familiar:");
        for (int i = 0; i < canchita.size(); i++) {
            Producto combo = canchita.get(i);
            System.out.println((i + 1) + ". " + combo.nombre + " - S/ " + combo.precioUnitario + " (" + combo.butaca + ")");
        }
        System.out.println((canchita.size() + 1) + ". Regresar");

        int opcion = pedirOpcion(canchita.size() + 1);

        if (opcion == canchita.size() + 1) {
            agregarDulces();

        } else {
            Producto comboSeleccionado = canchita.get(opcion - 1);
            System.out.println("¿Cuántos " + comboSeleccionado.nombre + " desea?");
            int cantidad = pedirCantidad();
            carrito.add(new Producto(comboSeleccionado.nombre, comboSeleccionado.precioUnitario, comboSeleccionado.butaca, cantidad));
            System.out.println(cantidad + " " + comboSeleccionado.nombre + " agregados a su carrito.");
            pedirdatoscompra();

        }
    }

    public static void agregarbebidas() {
        System.out.println("\nElija una bebida:");
        for (int i = 0; i < bebidas.size(); i++) {
            Producto combo = bebidas.get(i);
            System.out.println((i + 1) + ". " + combo.nombre + " - S/ " + combo.precioUnitario + " (" + combo.butaca + ")");
        }
        System.out.println((bebidas.size() + 1) + ". Regresar");

        int opcion = pedirOpcion(bebidas.size() + 1);

        if (opcion == bebidas.size() + 1) {
            agregarDulces();

        } else {
            Producto comboSeleccionado = bebidas.get(opcion - 1);
            System.out.println("¿Cuántos " + comboSeleccionado.nombre + " desea?");
            int cantidad = pedirCantidad();
            carrito.add(new Producto(comboSeleccionado.nombre, comboSeleccionado.precioUnitario, comboSeleccionado.butaca, cantidad));
            System.out.println(cantidad + " " + comboSeleccionado.nombre + " agregados a su carrito.");

        }
        pedirdatoscompra();
    }

    public static int pedirCantidad() {
        int cantidad;
        while (true) {
            try {
                System.out.println("Ingrese la cantidad:");
                cantidad = Integer.parseInt(luffy.nextLine());
                if (cantidad <= 0) {
                    System.out.println("Por favor ingrese una cantidad válida.");
                } else {
                    return cantidad;
                }
            } catch (Exception e) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }
    }


    public static void inicializarMapaButacas() {
        for (int i = 0; i < mapaButaca.length; i++) {
            for (int j = 0; j < mapaButaca[i].length; j++) {
                mapaButaca[i][j] = "○";
            }
        }
    }

    public static void mostrarCarrito() {
        System.out.println("\nCarrito de compras:");
        double total = 0;
        for (Producto producto : carrito) {
            System.out.println(producto.cantidad + "--" + producto.nombre + " - " + producto.butaca + " - S/ " + producto.getPrecioTotal());
            total += producto.getPrecioTotal();
        }
        System.out.println("Total: S/ " + total);
    }
    public static void mostrarCorporativo() {
        System.out.println("---Corporativo---");
        System.out.println("Conoce nuestros productos");
        System.out.println("Seleccione el producto de su interés");
        System.out.println("Opción 1: Eventos");
        System.out.println("Opción 2: Funciones Especiales");
        System.out.println("Opción 3: Planet Fiesta");
        System.out.println("Opción 4: Publicidad");
        System.out.println("Opción 0: Regresar");

        int opcion = luffy.nextInt();
        luffy.nextLine();  // Limpiar buffer

        switch (opcion) {
            case 1:
                eventos();
                break;
            case 2:
                funciones_especiales();
                break;
            case 3:
                planet_fiesta();
                break;
            case 4:
                publicidad();
                break;
            case 0:
                return;
            default:
                mostrarCorporativo();
        }
    }

    public static void eventos() {
        System.out.println("""
                EVENTOS
                Cuéntanos un poco más sobre tu solicitud y nuestro equipo se pondrá en contacto contigo.
                Por favor, considera los datos reales de empresa y contacto para atender tu solicitud.
                |-------------------------|               |-------------------------|
                | Regresar a Productos(1) |               |   Iniciar Solicitud(2)  |
                |-------------------------|               |-------------------------|
                Elija una opción:""");

        int opcion = luffy.nextInt();
        switch (opcion) {
            case 1:
                mostrarCorporativo();
                break;
            case 2:
                solicitudevento();
                break;
            default:
                eventos();
        }
    }

    public static void funciones_especiales() {
        System.out.println("""
                FUNCIONES ESPECIALES
                Cuéntanos un poco más sobre tu solicitud y nuestro equipo se pondrá en contacto contigo.
                Por favor, considera los datos reales de empresa y contacto para atender tu solicitud.
                |-------------------------|               |-------------------------|
                | Regresar a Productos(1) |               |   Iniciar Solicitud(2)  |
                |-------------------------|               |-------------------------|
                Elija una opción:""");

        int opcion = luffy.nextInt();
        switch (opcion) {
            case 1:
                mostrarCorporativo();
                break;
            case 2:
                solicitudespcial();
                break;
            default:
                funciones_especiales();
        }
    }

    public static void solicitudespcial() {
        System.out.println("Elige el contenido disponible en base a tu selección de cine.");
        System.out.println("La fecha de estreno de la película no debe exceder los 3 meses.");

        seleccionaPelicula();
        datos();
        detalles();
    }

    public static void planet_fiesta() {
        System.out.println("""
                PLANET FIESTA
                Cuéntanos un poco más sobre tu solicitud y nuestro equipo se pondrá en contacto contigo.
                Por favor, considera los datos reales de empresa y contacto para atender tu solicitud.
                |-------------------------|               |-------------------------|
                | Regresar a Productos(1) |               |   Iniciar Solicitud(2)  |
                |-------------------------|               |-------------------------|
                Elija una opción:""");

        int opcion = luffy.nextInt();
        switch (opcion) {
            case 1:
                mostrarCorporativo();
                break;
            case 2:
                solicitudespcial();
                break;
            default:
                planet_fiesta();
        }
    }

    public static void publicidad() {
        System.out.println("""
                PUBLICIDAD
                Cuéntanos un poco más sobre tu solicitud y nuestro equipo se pondrá en contacto contigo.
                Por favor, considera los datos reales de empresa y contacto para atender tu solicitud.
                |-------------------------|               |-------------------------|
                | Regresar a Productos(1) |               |   Iniciar Solicitud(2)  |
                |-------------------------|               |-------------------------|
                Elija una opción:""");

        int opcion = luffy.nextInt();
        switch (opcion) {
            case 1:
                mostrarCorporativo();
                break;
            case 2:
                solicitudpublicidad();
                break;
            default:
                publicidad();
        }
    }

    public static void solicitudpublicidad() {
        System.out.println("Elige el tipo de publicidad que desea cotizar");
        System.out.println("""
                Opción 1: Publicidad en Pantalla 
                Opción 2: Publicidad en lobby
                """);
        System.out.println("Duración del video:");
        System.out.println("""
                Opción 1: De 10 a 20 segundos
                Opción 2: De 21 a 30 segundos
                Opción 3: De 31 a 45 segundos
                Opción 4: De 46 a 60 segundos
                """);
        System.out.println("Tiempo de permanencia:");
        luffy.nextLine();
        System.out.println("Nombre de la Empresa:");
        empresa = luffy.nextLine();
        System.out.println("Nombre de contacto:");
        contacto = luffy.nextLine();
        System.out.println("DNI:");
        dni = luffy.nextInt();
        System.out.println("Número de celular:");
        numero = luffy.nextInt();
        luffy.nextLine();
        System.out.println("Correo electrónico:");
        correo = luffy.nextLine();
        mostrarCorporativo();
    }

    public static void solicitudevento() {
        System.out.println("Seleccione el tipo de evento que quiere cotizar:");
        System.out.println("1. Zona Gamer");
        System.out.println("2. Zona Reunión");
        System.out.println("3. Lanzamiento");
        System.out.println("4. Club de Fans");
        System.out.println("0. Regresar");

        int opcion = luffy.nextInt();
        switch (opcion) {
            case 1, 2, 3, 4:
                datos();
                detalles();
                break;
            case 0:
                eventos();
            default:
                solicitudevento();
        }
    }

    public static void datos() {
        System.out.println("Fecha de reservación de la sala");
        System.out.println("Ingrese el día:");
        dia = luffy.nextInt();
        System.out.println("Ingrese el mes:");
        mes = luffy.nextInt();
        System.out.println("Ingrese el año:");
        año = luffy.nextInt();
        String fecha = dia + "/" + mes + "/" + año;
        fechas.add(fecha);
        System.out.println("Fecha ingresada: " + fecha);
        System.out.println("Tipo de solicitante:");
        System.out.println("""
                Opción 1: Empresa
                Opción 2: Persona natural
                """);
        luffy.nextLine();
        System.out.println("Nombre de contacto:");
        nombre = luffy.nextLine();
        System.out.println("DNI:");
        dni = luffy.nextInt();
        System.out.println("Número de celular:");
        numero = luffy.nextInt();
        luffy.nextLine();
        System.out.println("Correo electrónico:");
        correo = luffy.nextLine();

        String datos = "\nNombre: " + nombre
                + "\nDNI: " + dni
                + "\nNúmero: " + numero
                + "\nCorreo: " + correo;
        datosSolicitudes.add(datos);
    }

    public static void detalles() {
        System.out.println("Capacidad de la sala:");
        System.out.println("""
                1. Hasta 200 butacas
                2. Más de 200 butacas
                3. Más de 300 butacas
                4. Más de 400 butacas
                5. Hasta 100 butacas (Prime)
                """);
        int opcion = luffy.nextInt();
        switch (opcion) {
            case 1:
                capacidad = "Hasta 200 butacas";
                break;
            case 2:
                capacidad = "Más de 200 butacas";
                break;
            case 3:
                capacidad = "Más de 300 butacas";
                break;
            case 4:
                capacidad = "Más de 400 butacas";
                break;
            case 5:
                capacidad = "Hasta 100 butacas (Prime)";
                break;
            default:
                detalles();
        }

        exportarDatos();
    }

    public static void seleccionaPelicula() {
        System.out.println("Selecciona la película que deseas:");
        System.out.println("1) Un perro especial");
        System.out.println("2) La confesion del diablo");
        System.out.println("3) La sustancia");
        System.out.println("4) Robot salvaje");
        int opcion = luffy.nextInt();
        switch (opcion) {
            case 1:
                peliculaSeleccionada = "Un perro especial";
                break;
            case 2:
                peliculaSeleccionada = "La confesion del diablo";
                break;
            case 3:
                peliculaSeleccionada = "La sustancia";
                break;
            case 4:
                peliculaSeleccionada = "Robot salvaje";
                break;
            default:
                seleccionaPelicula();
                return;
        }
        System.out.println("Película seleccionada: " + peliculaSeleccionada);
    }

    public static void exportarDatos() {
        try {
            FileWriter writer = new FileWriter("solicitudes.txt", true);
            writer.write("====================================\n");
            writer.write("         Detalles de la Solicitud         \n");
            writer.write("====================================\n");
            writer.write(String.format("%-20s: %s\n", "Fecha", fechas.get(fechas.size() - 1)));
            writer.write(String.format("%-20s: %s\n", "Película", peliculaSeleccionada));
            writer.write(String.format("%-20s: %s\n", "Datos del Solicitante", datosSolicitudes.get(datosSolicitudes.size() - 1)));
            writer.write(String.format("%-20s: %s\n", "Capacidad de la Sala", capacidad));
            writer.write("====================================\n\n");
            writer.close();
            System.out.println("¡Datos exportados con éxito!");
        } catch (IOException e) {
            System.out.println("Error al exportar los datos: " + e.getMessage());
        }
    }

    public static void pedirdatoscompra() {
        mostrarCarrito();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                ================================================================
                🎬   ¡ CinePlanet! La mejor experiencia cinematográfica  🎥
                ================================================================
                ✨ ¡Completa tu compra para disfrutar de tus películas favoritas! ✨
                ================================================================
                """);


        System.out.print("\n🌟 Por favor, ingresa los siguientes datos para completar tu compra:\n");

        System.out.print("💎 Nombre completo: ");
        String nombre1 = sc.nextLine();

        System.out.print("📧 Correo electrónico: ");
        String correo = sc.nextLine();

        String telefono = "";
        int intentos = 0;

        while (intentos < 3) {
            System.out.print("\n📱 Ingresa tu número de teléfono (9 dígitos): ");
            telefono = sc.nextLine();

            if (telefono.length() == 9) {
                System.out.println("\n✔️ ¡Número de teléfono registrado correctamente!");
                break;
            } else {
                intentos++;
                System.out.println("❌ Número incorrecto. El número debe tener 9 dígitos.");
                System.out.println("Intento " + intentos + " de 3.");
                System.out.println("---------------------------------------------------------------");
            }
        }

        if (intentos == 3) {
            System.out.println("\n🚫 ¡Usuario bloqueado por 24 horas debido a intentos fallidos!");
            System.exit(0);
        }

        seleccionarMetodoPago(sc, correo, nombre1, telefono);
    }

    public static void seleccionarMetodoPago(Scanner sc, String correo, String nombre1, String telefono) {
        boolean pagoCompletado = false;


        while (!pagoCompletado) {
            System.out.println("\n====================================");
            System.out.println("⚡  Selecciona tu método de pago ⚡");
            System.out.println("====================================");
            System.out.println("1: 💳 Tarjeta de crédito/débito");
            System.out.println("2: 💸 EFECTIVO");
            System.out.println("====================================");
            System.out.println("Elige una opción : ");

            int metodoPago = sc.nextInt();
            sc.nextLine();


            switch (metodoPago) {
                case 1:
                    procesarPagoConTarjeta(sc, telefono);
                    pagoCompletado = true;
                    break;

                case 2:
                    procesarPagoEnEfectivo(sc, telefono, nombre1, correo);
                    break;

                default:
                    System.out.println("❌ Opción no válida. Por favor, selecciona una opción válida (1 o 2).");
                    System.out.println("-----------------------------------------------------");
                    break;
            }
        }
        mostrarRecibo(nombre1, correo);
    }

    private static boolean procesarPagoConTarjeta(Scanner sc, String telefono) {
        boolean pagoAceptado= false;
        long tarjeta;


        System.out.println("\n=====================================");
        System.out.println("💳 Ingreso de datos para el pago con tarjeta 💳");
        System.out.println("=====================================");


        while (true) {
            System.out.print("🔢 Número de tarjeta (16 dígitos): ");
            tarjeta = sc.nextLong();
            if (String.valueOf(tarjeta).length() == 16) {
                break;
            }
            System.out.println("❌ Error: El número de tarjeta debe contener exactamente 16 dígitos numéricos.");
        }
        sc.nextLine();


        System.out.print("👤 Nombre en la tarjeta: ");
        String titular = sc.nextLine();


        String fecha;
        while (true) {
            System.out.print("📅 Fecha de vencimiento (MM/AA): ");
            fecha = sc.nextLine();
            if (fecha.length() == 5 && fecha.charAt(2) == '/') {
                break;
            }
            System.out.println("❌ Error: La fecha de vencimiento debe estar en formato MM/AA.");
        }


        int cvv;
        while (true) {
            System.out.print("🔒 CVV (3 dígitos): ");
            cvv = sc.nextInt();
            if (String.valueOf(cvv).length() == 3) {
                break;
            }
            System.out.println("❌ Error: El CVV debe contener exactamente 3 dígitos numéricos.");
        }


        System.out.println("\n=====================================");
        System.out.println("🔄 Procesando el pago...");
        System.out.println("=====================================");
        System.out.println("💳 Tarjeta " + String.valueOf(tarjeta).substring(0, 4) + " **** **** **** procesada correctamente.");
        System.out.println("🗓️ Fecha de vencimiento: " + fecha);
        System.out.println("✅ ¡Pago exitoso!");
        System.out.println("=====================================");

        return pagoAceptado;
    }
    private static boolean procesarPagoEnEfectivo(Scanner sc, String telefono, String nombre, String correo) {
        int intentos = 0;
        boolean pagoAceptado = false;

        while (!pagoAceptado && intentos <= 3) {

            double total = carrito.stream().mapToDouble(Producto::getPrecioTotal).sum();
            System.out.println("Costo total: S/. " + String.format("%.2f", total));
            System.out.print("Con cuánto pagará (S/.): ");
            double moneda = sc.nextDouble();

            if (moneda >= total) {
                double vuelto = moneda - total;
                System.out.println("Su vuelto será : S/" + String.format("%.2f", vuelto));
                System.out.println("Con el costo total de: S/" + String.format("%.2f", total));
                pagoAceptado = true;
                mostrarRecibo(nombre, correo);
            } else {
                intentos++;
                if (intentos < 3) {
                    System.out.println("El monto ingresado es insuficiente. Intente de nuevo.");
                } else {
                    System.out.println("Número máximo de intentos alcanzado. ¡Pedido cancelado!");
                }
            }
        }
        return pagoAceptado;
    }

    private static void mostrarRecibo(String nombre1, String correo) {
        String userHome = System.getProperty("user.home");
        String downloadFolder = Paths.get(userHome, "Downloads", "recibo_compra.txt").toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(downloadFolder))) {
            writer.write("""
                    \n__________________________________________________________________________________________________________________________
                    ||                                                                                                                         ||
                    """);
            System.out.println("""
                    \n__________________________________________________________________________________________________________________________
                    ||                                                                                                                         ||
                    """);
            writer.write("\n||     --- RECIBO DE COMPRA ---");
            System.out.println("||     --- RECIBO DE COMPRA ---");
            for (Producto producto : carrito) {
                System.out.println(producto.butaca);
            }
            LocalDateTime ahora = LocalDateTime.now();
            writer.write("\n||         Nombre del cliente: " + nombre1);
            System.out.println("||         Nombre del cliente: " + nombre1);
            writer.write("\n||         Correo electrónico: " + correo);
            System.out.println("||         Correo electrónico: " + correo);
            writer.write("\n||         Productos comprados:\n");
            System.out.println("||         Productos comprados:\n");
            double preciototal = 0;
            for (Producto producto : carrito) {
                preciototal += producto.getPrecioTotal();
                writer.write("\n||" +producto.cantidad+" : " + producto.nombre + " | Precio total: S/. " + String.format("%.2f", producto.getPrecioTotal()) );
                System.out.println("||" +producto.cantidad +" : "+ producto.nombre + " | Precio total: S/. " + String.format("%.2f", producto.getPrecioTotal()) );
            }
            double precioigv = 0.18 * preciototal;
            double preciofinish = preciototal - precioigv;

            writer.write("\n||-------------------------------------------------------------------------------------------------------------------||");
            System.out.println("||-------------------------------------------------------------------------------------------------------------------||");
            writer.write("\n||               COSTO del producto (sin IGV)  =  S/. " + String.format("%.2f", preciofinish));
            System.out.println("||               COSTO del producto (sin IGV)  =  S/. " + String.format("%.2f", preciofinish));
            writer.write("\n||               COSTO del IGV (18%)           =  S/. " + String.format("%.2f", precioigv));
            System.out.println("||               COSTO del IGV (18%)           =  S/. " + String.format("%.2f", precioigv));
            writer.write("\n||____________________________________________________________________________________________________________________||");
            System.out.println("||____________________________________________________________________________________________________________________||");
            writer.write("\n||               Total a pagar                =  S/. " + String.format("%.2f", preciototal));
            System.out.println("||               Total a pagar                =  S/. " + String.format("%.2f", preciototal));
            writer.write("\n||____________________________________________________________________________________________________________________||");
            System.out.println("||____________________________________________________________________________________________________________________||");


            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fecha = ahora.format(formato);
            writer.write("                   \nrecibo generado :   " + fecha);
            System.out.println("                      recibo generado :   " + fecha);
            System.out.println();
            writer.write("\n                                                 Gracias por compar en cineplanet!");
            System.out.println("                                                 Gracias por compar en cineplanet!");
            writer.write("\n                                    ¡Vuelva pronto!");
            System.out.println("                                    ¡Vuelva pronto!");
            writer.write("\n                                             FELIZ NAVIDAD 🎅🎄");
            System.out.println("                                             FELIZ NAVIDAD 🎅🎄");

            System.out.println("            el recibo se almaceno en : " + downloadFolder);

        } catch (IOException e) {
            System.err.println("                    error de sistema 404 : " + e.getMessage());
        }
        System.exit(0);
    }

}

