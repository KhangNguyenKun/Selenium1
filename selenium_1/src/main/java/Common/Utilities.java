package Common;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Utilities {
    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;



    public static String getCellData(int RowNum, int ColNum) throws Exception {

        DataFormatter dataFormatter= new DataFormatter();
        try {

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            CellType dataType = Cell.getCellType();

            if (dataType == CellType.BLANK) {

                return "";

            } else {

                String CellData = dataFormatter.formatCellValue(Cell) ;

                return CellData;

            }

        }
        catch(Exception e){

            System.out.println(e.getMessage());

            throw (e);

        }
    }
    //This method is to set the File path and to open the Excel file, Pass Excel Path and
    // Sheetname as Arguments to this method

    public static String getTestCaseName(String sTestCase)throws Exception{

        String value = sTestCase;

        try{

            int posi = value.indexOf("@");

            value = value.substring(0, posi);

            posi = value.lastIndexOf(".");

            value = value.substring(posi + 1);

            return value;

        }catch (Exception e){

            throw (e);

        }

    }

    public static int getRowContains(String sTestCaseName, int colNum) throws Exception{

        int i;

        try {

            int rowCount = Utilities.getRowUsed();

            for ( i=0 ; i<rowCount; i++){

                if  (Utilities.getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){

                    break;

                }

            }

            return i;

        }catch (Exception e){

            throw(e);

        }

    }

    public static int getRowUsed() throws Exception {

        try{

            int RowCount = ExcelWSheet.getLastRowNum();

            return RowCount;

        }catch (Exception e){

            System.out.println(e.getMessage());

            throw (e);

        }

    }

    public static void setExcelFile(String Path,String SheetName) throws Exception {

        try {

            // Open the Excel file

            FileInputStream ExcelFile = new FileInputStream(Path);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

        } catch (Exception e){

            throw (e);

        }

    }

    public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow) throws Exception

    {

        Object[][] tabArray = null;

        try{

            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

            int startCol = 1;
            int startRow = 1;

            int ci,cj;

            int totalRows = ExcelWSheet.getLastRowNum();

            // you can write a function as well to get Column count

            int totalCols = 5;

            tabArray=new String[totalRows][totalCols];

            ci=0;

            for (int i=startRow;i<=totalRows;i++, ci++) {

                cj=0;
//                 totalCols = ExcelWSheet.getRow(i).getLastCellNum();

                for (int j=startCol;j<=totalCols;j++, cj++){

                    tabArray[ci][cj]=getCellData(i,j);

                    System.out.println(tabArray[ci][cj]);

                }

            }

        }

        catch (FileNotFoundException e)

        {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        catch (IOException e)

        {

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        return(tabArray);

    }

}
