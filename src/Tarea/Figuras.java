/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea;

/**
 *
 * @author admin
 */
public class Figuras
{

    private int numeroCaracteres;
    private char caracter;
    private final char espacio = ' ';

    public Figuras()
    {
        this.numeroCaracteres = 7;
        this.caracter = '*';
    }

    public Figuras(int numeroCaracteres)
    {
        this.numeroCaracteres = numeroCaracteres;
        this.caracter = '*';
    }

    public Figuras(char caracter)
    {
        this.numeroCaracteres = 5;
        this.caracter = caracter;
    }

    public Figuras(int numeroCaracteres, char caracter)
    {
        this.numeroCaracteres = numeroCaracteres;
        this.caracter = caracter;
    }

    /**
     * @return the numeroCaracteres
     */
    public int getNumeroCaracteres()
    {
        return numeroCaracteres;
    }

    /**
     * @param numeroCaracteres the numeroCaracteres to set
     */
    public void setNumeroCaracteres(int numeroCaracteres)
    {
        this.numeroCaracteres = numeroCaracteres;
    }

    /**
     * @return the caracter
     */
    public char getCaracter()
    {
        return caracter;
    }

    /**
     * @param caracter the caracter to set
     */
    public void setCaracter(char caracter)
    {
        this.caracter = caracter;
    }

    private void linea(int n, int caracter, boolean saltoLinea)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.print((char) caracter + "" + (char) espacio);
        }

        if (saltoLinea)
        {
            System.out.println("");
        }
    }

    private void trianguloRec()
    {
        for (int i = 1; i <= numeroCaracteres - 1; i++)
        {
            linea(i, caracter, true);
        }
    }

    private void trianguloRec(boolean lado)
    {
        for (int i = 1; i < numeroCaracteres; i++)
        {
            if (i < 3 || i == numeroCaracteres)
            {
                linea(i, caracter, true);
            } else
            {
                linea(1, caracter, false);
                linea(i - 2, espacio, false);
                linea(1, caracter, true);
            }
        }

        if (lado)
        {
            linea(numeroCaracteres, caracter, true);
        }
    }

    public void trianguloRectangulo()
    {
        trianguloRec();
    }

    public void trianguloRectangulo(boolean relleno)
    {
        if (relleno)
        {
            trianguloRectangulo();
        } else
        {
            trianguloRec(true);
        }

    }

    private void triangulo()
    {
        int i = (numeroCaracteres % 2 == 0) ? 2 : 1;
        for (; i <= numeroCaracteres; i += 2)
        {
            linea((numeroCaracteres - i) / 2, espacio, false);
            linea(i, caracter, true);
        }
    }

    private void triangulo(boolean lado)
    {
        int i = (numeroCaracteres % 2 == 0) ? 2 : 1;
        for (; i <= numeroCaracteres; i += 2)
        {
            linea((numeroCaracteres - i) / 2, espacio, false);
            if (i >= 2)
            {
                linea(1, caracter, false);
                if (lado && (i == numeroCaracteres))
                {
                    linea(numeroCaracteres - 2, caracter, false);
                } else
                {
                    linea(i - 2, espacio, false);
                }
            }

            linea(1, caracter, true);
        }
    }

    private void trianguloInvertido()
    {
        int r = (numeroCaracteres % 2 == 0) ? 2 : 1;
        for (int i = numeroCaracteres; i >= r; i -= 2)
        {
            linea((numeroCaracteres - i) / 2, espacio, false);
            linea(i, caracter, true);
        }
    }

    private void trianguloInvertido(boolean lado)
    {
        int r = (numeroCaracteres % 2 == 0) ? 2 : 1;
        for (int i = numeroCaracteres; i >= r; i -= 2)
        {
            linea((numeroCaracteres - i) / 2, espacio, false);
            linea(1, caracter, false);

            if (lado)
            {
                linea(numeroCaracteres - 2, caracter, false);
                lado = false;
            } else
            {
                linea(i - 2, espacio, false);
            }

            if (r == 2 || (r == 1 && r < i))
            {
                linea(1, caracter, true);
            }
        }

        if (r == 1)
        {
            System.out.println("");
        }
    }

    public void rombo()
    {
        triangulo();
        trianguloInvertido();
    }

    public void rombo(boolean rellono)
    {
        if (rellono)
        {
            rombo();
        } else
        {
            triangulo(false);
            trianguloInvertido(false);
        }
    }

    public void reloj()
    {
        trianguloInvertido();
        triangulo();
    }

    public void reloj(boolean rellono)
    {
        if (rellono)
        {
            reloj();
        } else
        {
            trianguloInvertido(true);
            triangulo(true);
        }

    }

    private void triangulRecInvertido()
    {
        for (int i = numeroCaracteres; i > 0; i--)
        {
            if (i != numeroCaracteres)
            {
                linea(numeroCaracteres * 2 - i, espacio, false);
            }
            linea(i, caracter, true);
        }
    }

    private void triangulRecInvertido(boolean lado)
    {
        for (int i = numeroCaracteres - 1; i > 0; i--)
        {

            linea(numeroCaracteres * 2 - i, espacio, false);
            linea(1, caracter, false);
            linea(i - 2, espacio, false);
            if (i > 1)
            {
                linea(1, caracter, true);
            } else
            {
                System.out.println("");
            }
        }
    }

    public void triangulos()
    {
        trianguloRec();
        linea(numeroCaracteres, caracter, false);
        triangulRecInvertido();
    }

    public void triangulos(boolean relleno)
    {
        trianguloRec(false);
        linea(numeroCaracteres * 2, caracter, true);
        triangulRecInvertido(true);
    }

    public void monio()
    {
        for (int i = 1; i <= numeroCaracteres; i++)
        {
            linea(i, caracter, false);
            linea(numeroCaracteres * 2 - (i * 2), espacio, false);
            linea(i, caracter, true);
        }

        for (int i = numeroCaracteres - 1; i > 0; i--)
        {
            linea(i, caracter, false);
            linea(numeroCaracteres * 2 - (i * 2), espacio, false);
            linea(i, caracter, true);
        }
    }

    public void monio(boolean relleno)
    {
        for (int i = 1; i <= numeroCaracteres; i++)
        {
            if (i < 3)
            {
                linea(i, caracter, false);
            } else
            {
                linea(1, caracter, false);
                linea(i - 2, espacio, false);
                linea(1, caracter, false);
            }

            linea(numeroCaracteres * 2 - (i * 2), espacio, false);

            if (i < 3)
            {
                linea(i, caracter, true);
            } else
            {
                linea(1, caracter, false);
                linea(i - 2, espacio, false);
                linea(1, caracter, true);
            }
        }

        for (int i = numeroCaracteres; i > 0; i--)
        {
            if (i < 2)
            {
                linea(i, caracter, false);
            } else
            {
                linea(1, caracter, false);
                linea(i - 2, espacio, false);
                linea(1, caracter, false);
            }

            linea(numeroCaracteres * 2 - (i * 2), espacio, false);

            if (i < 2)
            {
                linea(i, caracter, true);
            } else
            {
                linea(1, caracter, false);
                linea(i - 2, espacio, false);
                linea(1, caracter, true);
            }
        }
    }

    public void logo()
    {
        int left_space = (numeroCaracteres - 1) * (numeroCaracteres - 1);
        int right_space = numeroCaracteres - 2;
        int i;
        for (i = 0; i < numeroCaracteres; i++)
        {
            linea(left_space, espacio, false);
            linea(numeroCaracteres, caracter, false);
            if (i > 0)
            {
                linea(right_space, espacio, false);
                linea(numeroCaracteres, caracter, false);
                right_space += 2 * (numeroCaracteres - 1);
            }
            left_space -= numeroCaracteres - 1;
            System.out.println("");
        }

        for (i = numeroCaracteres; i > 0; i--)
        {
            left_space += numeroCaracteres - 1;
            linea(left_space, espacio, false);
            linea(numeroCaracteres, caracter, false);
            if (i > 1)
            {
                right_space -= 2 * (numeroCaracteres - 1);
                linea(right_space, espacio, false);
                linea(numeroCaracteres, caracter, false);
            }
            System.out.println("");
        }
    }

    public void escalera()
    {
        int spaces = numeroCaracteres - 2;
        linea(numeroCaracteres, caracter, true);

        for (int i = 1; i < numeroCaracteres * (numeroCaracteres - 1); i++)
        {
            System.out.print(caracter + " ");
            linea(spaces, espacio, false);
            if (i % (numeroCaracteres - 1) == 0)
            {
                linea(numeroCaracteres, caracter, false);
                spaces += numeroCaracteres - 1;
            } else
            {
                System.out.print(caracter);
            }
            System.out.println("");
        }
        linea(numeroCaracteres * (numeroCaracteres - 1) + 1, caracter, true);
    }

    private void cuboEspaciado(int n)
    {
        for (int i = 0; i < numeroCaracteres * n; i++)
        {
            linea(numeroCaracteres, espacio, false);
            linea(numeroCaracteres, caracter, true);
        }
    }

    public void cruz()
    {
        cuboEspaciado(1);
        for (int i = 0; i < numeroCaracteres; i++)
        {
            linea(numeroCaracteres * 3, caracter, true);
        }
        cuboEspaciado(2);
    }

    private void cuboEspaciado(int n, boolean lado)
    {
        for (int i = 0; i < numeroCaracteres * n; i++)
        {
            linea(numeroCaracteres, espacio, false);
            if ((lado && i == 0) || (!lado && i == numeroCaracteres * n - 1))
            {
                linea(numeroCaracteres, caracter, true);
            } else
            {
                linea(1, caracter, false);
                linea(numeroCaracteres - 2, espacio, false);
                linea(1, caracter, true);
            }

        }
    }

    public void cruz(boolean relleno)
    {
        cuboEspaciado(1, true);
        for (int i = 0; i < numeroCaracteres; i++)
        {
            if (i == 0 || i == numeroCaracteres - 1)
            {
                linea(numeroCaracteres+1, caracter, false);
                linea(numeroCaracteres-2, espacio, false);
                linea(numeroCaracteres+1, caracter, true);
            } else
            {
                linea(1, caracter, false);
                linea(numeroCaracteres * 3 -2, espacio, false);
                linea(1, caracter, true);
            }

        }
        cuboEspaciado(2, false);
    }

    public void contorno()
    {
        int spaces = 0;

        for (int i = numeroCaracteres; i >= 1; i--)
        {
            linea(i, caracter, false);
            linea(spaces, espacio, false);
            linea(i, caracter, true);
            spaces += 2;
        }

        for (int i = 1; i <= numeroCaracteres; i++)
        {
            spaces -= 2;
            linea(i, caracter, false);
            linea(spaces, espacio, false);
            linea(i, caracter, true);
        }
    }
}
