package sort;

import java.awt.BasicStroke;
import java.util.Arrays;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Sort {

    public static int[] randomArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * 100);
        }
        return a;
    }

    public static int bubbleSort(int[] list, int n) {
        int contador = 0;
        //int formulaBurbujaPeor = (6 * (int) (Math.pow(n, 2))) - 3;
        //int formulaBurbujaPromedio = (17 * n * n + 7 * n - 12) / 4;
        //int formulaBurbujaMejor = 5 * (n * n - (((n - 1) * n) / 2) - n) + 6 * (n - 1) + 3;

        int temp = 0;
        int[] a = list;
        contador += 3;
        for (int i = 0; i < n - 1; i++) {
            contador += 6;
            for (int j = i + 1; j < n; j++) {
                contador += 5;
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    contador += 7;
                }
            }
        }

        //System.out.println("Burbuja peor caso: " + formulaBurbujaPeor);
        //System.out.println("Burbuja caso promedio: " + formulaBurbujaPromedio);
        //System.out.println("Burbuja mejor caso: " + formulaBurbujaMejor);
        //System.out.println("Contador: " + contador);
        //return formulaBurbujaPromedio;
        
        return contador;
        //return 0;
    }

    public static int selectionSort(int[] list, int n) {
        int N = n;
        int a[] = list;
        int contador = 0;
        //double formulaSeleccionPeor = 7 * ((n * n) / (double) 4) + 16 * (n / (double) 2) + 3;
        //double formulaSeleccionMejor = 6 * ((n * n) / (double) 4) + 9 * (n / (double) 2) + 3;
        //double formulaSeleccionPromedio = 6 * ((n * n) / (double) 4) + 9 * (n / (double) 2) + 3 + ((((n * n) / (double) 4) + 7 * (n / (double) 2)) / (double) 2);

        int t, i, j, x;
        for (i = 0; i < N / 2.0; i++) {
            contador = contador + 9;
            x = i;
            for (j = i + 1; j < N - i; j++) {
                contador += 6;
                if (a[x] > a[j]) {
                    x = j;
                    contador += 1;
                }
            }

            if (i != x) {
                contador += 7;
                t = a[i];
                a[i] = a[x];
                a[x] = t;
            }
        }
        contador += 3;

        //System.out.println("Selección peor caso: " + formulaSeleccionPeor);
        //System.out.println("Selección caso promedio: " + formulaSeleccionPromedio);
        //System.out.println("Selección mejor caso: " + formulaSeleccionMejor);
        //System.out.println("Contador: " + contador);
        //return formulaSeleccionPromedio;
        return contador;
        //return 0;
    }

    public static int insertionSort(int[] list, int n) {
        double N = (double) n - 1;
        int a[] = list;

        //double formulaPeorInsercion = 8 * ((N / (double) 2) * (N + 1) - N) + 12 * (N - 1) + 4;
        //double formulaPromedioInsercion = (double) 12 * (N - 1) + 4 + ((8 * ((N / (double) 2) * (N + 1) - N)) / (double) 2);
        //double formulaMejorInsercion = (double) 12 * (N - 1) + 4;
        int contador = 0;

        a[0] = -32767;
        int i = 2;
        int j, temp;
        contador = 4;

        while (i <= N) {
            j = i - 1;
            temp = a[i];
            while (temp < a[j]) {
                a[j + 1] = a[j];
                j = j - 1;
                contador += 8;
            }
            a[j + 1] = temp;
            i = i + 1;
            contador += 12;
        }
        //System.out.println("Inserción peor caso: " + formulaPeorInsercion);
        //System.out.println("Inserción caso promedio: " + formulaPromedioInsercion);
        //System.out.println("Inserción mejor caso: " + formulaMejorInsercion);
        //System.out.println("Contador: " + contador);
        //return formulaPromedioInsercion;

        return contador;
        //return 0;
    }

    public static int radixSort(int[] list, int n) {
        int contador = 0;

        // Find the maximum number to know number of digits 
        int mx = list[0];
        contador += 2;

        contador += 2;
        for (int i = 1; i < n; i++) {
            contador += 2;

            contador++;
            if (list[i] > mx) {
                mx = list[i];
                contador += 2;
            }
        }

        // Do counting sort for every digit. Note that instead 
        // of passing digit number, exp is passed. exp is 10^i 
        // where i is current digit number 
        contador += 3;
        for (int exp = 1; mx / exp > 0; exp *= 10) {
            contador += 4;

            int output[] = new int[n]; // output array 
            contador += 2;

            int i;
            int count[] = new int[10];
            contador += 2;
            Arrays.fill(count, 0);
            contador++;

            // Store count of occurrences in count[] 
            contador += 2;
            for (i = 0; i < n; i++) {
                contador += 2;

                count[(list[i] / exp) % 10]++;
                contador += 6;
            }

            // Change count[i] so that count[i] now contains 
            // actual position of this digit in output[] 
            contador += 2;
            for (i = 1; i < 10; i++) {
                contador += 2;

                count[i] += count[i - 1];
                contador += 5;
            }

            // Build the output array 
            contador += 3;
            for (i = n - 1; i >= 0; i--) {
                contador += 3;

                output[count[(list[i] / exp) % 10] - 1] = list[i];
                contador += 8;

                count[(list[i] / exp) % 10]--;
                contador += 6;
            }

            // Copy the output array to arr[], so that arr[] now 
            // contains sorted numbers according to curent digit 
            contador += 2;
            for (i = 0; i < n; i++) {
                contador += 2;

                list[i] = output[i];
                contador += 3;
            }
        }

        return contador;
    }

    public static int mergeSort(int[] list, int l, int r) {
        int contador = 0;

        contador++;
        if (l < r) {
            // Find the middle point 
            int m = (l + r) / 2;
            contador += 3;

            // Sort first and second halves 
            mergeSort(list, l, m);
            mergeSort(list, m + 1, r);
            contador += 3;

            // Merge the sorted halves
            // Find sizes of two subarrays to be merged 
            int n1 = m - l + 1;
            int n2 = r - m;
            contador += 5;

            /* Create temp arrays */
            int L[] = new int[n1];
            int R[] = new int[n2];
            contador += 4;

            contador += 2;
            for (int i = 0; i < n1; ++i) {
                contador += 2;

                L[i] = list[l + i];
                contador += 4;
            }

            contador += 2;
            for (int j = 0; j < n2; ++j) {
                contador += 2;

                R[j] = list[m + 1 + j];
                contador += 5;
            }

            int i = 0, j = 0;
            contador += 2;

            int k = l;
            contador++;

            contador += 3;
            while (i < n1 && j < n2) {
                contador += 3;

                contador += 3;
                if (L[i] <= R[j]) {

                    list[k] = L[i];
                    contador += 3;

                    i++;
                    contador += 2;

                } else {
                    list[k] = R[j];
                    contador += 3;

                    j++;
                    contador += 2;
                }
                k++;
                contador += 2;
            }

            contador++;
            while (i < n1) {
                contador++;

                list[k] = L[i];
                contador += 3;

                i++;
                k++;
                contador += 4;
            }

            contador++;
            while (j < n2) {
                contador++;

                list[k] = R[j];
                contador += 3;

                j++;
                k++;
                contador += 4;
            }
        }

        return contador;
    }

    public static int quickSort(int[] list, int low, int high) {
        int contador = 0;

        contador += 1;
        if (low < high) {

            int pivot = list[high];
            contador += 2;

            int i = (low - 1);
            contador += 2;

            contador += 2;
            for (int j = low; j < high; j++) {
                contador += 2;

                contador += 2;
                if (list[j] < pivot) {

                    i++;
                    contador += 2;

                    int temp = list[i];
                    contador += 2;

                    list[i] = list[j];
                    contador += 3;

                    list[j] = temp;
                    contador += 2;
                }
            }

            int temp = list[i + 1];
            contador += 3;

            list[i + 1] = list[high];
            contador += 4;

            list[high] = temp;
            contador += 2;

            int pi = i + 1;
            contador += 2;

            quickSort(list, low, pi - 1);
            contador += 2;

            quickSort(list, pi + 1, high);
            contador += 2;
        }

        return contador;
    }

    public static void main(String[] args) {
        
        int sizeMax = 100;

        XYSeries bubble = new XYSeries("Burbuja");

        for (int i = 1; i <= sizeMax; i++) {
            int c[] = randomArray(i);
            bubble.add(i, bubbleSort(c, i));
        }

        XYSeries selection = new XYSeries("Seleccion");

        for (int i = 1; i <= sizeMax; i++) {
            int c[] = randomArray(i);
            selection.add(i, selectionSort(c, i));
        }

        XYSeries insertion = new XYSeries("Insercion");

        for (int i = 1; i <= sizeMax; i++) {
            int c[] = randomArray(i);
            insertion.add(i, insertionSort(c, i));
        }

        XYSeries radix = new XYSeries("Radix");

        for (int i = 1; i <= sizeMax; i++) {
            int c[] = randomArray(i);
            radix.add(i, radixSort(c, c.length));
        }

        XYSeries merge = new XYSeries("Merge");

        for (int i = 1; i <= sizeMax; i++) {
            int c[] = randomArray(i);
            merge.add(i, mergeSort(c, 0, i - 1));
        }

        XYSeries quick = new XYSeries("Quick");

        for (int i = 1; i <= sizeMax; i++) {
            int c[] = randomArray(i);
            quick.add(i, quickSort(c, 0, i - 1));
        }

        XYSeriesCollection dataSet = new XYSeriesCollection();

        dataSet.addSeries(bubble);
        dataSet.addSeries(insertion);
        dataSet.addSeries(selection);
        dataSet.addSeries(radix);
        dataSet.addSeries(merge);
        dataSet.addSeries(quick);

        JFreeChart xyLineChart = ChartFactory.createXYLineChart("Comparación entre métodos de ordenamiento", "Método", "Cantidad de operaciones", dataSet, PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = xyLineChart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        /*
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.GREEN);
        renderer.setSeriesPaint(2, Color.ORANGE);
        renderer.setSeriesPaint(3, Color.BLACK);
        renderer.setSeriesPaint(4, Color.YELLOW);
        renderer.setSeriesPaint(5, Color.RED);
        */
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        renderer.setSeriesStroke(1, new BasicStroke(1.0f));
        renderer.setSeriesStroke(2, new BasicStroke(1.0f));
        renderer.setSeriesStroke(3, new BasicStroke(1.0f));
        renderer.setSeriesStroke(4, new BasicStroke(1.0f));
        renderer.setSeriesStroke(5, new BasicStroke(1.0f));
        plot.setRenderer(renderer);

        ChartPanel panel = new ChartPanel(xyLineChart);

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(900, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

    }

}
