package id.lsa.scb.spring.integration.routers;

import id.lsa.scb.mappers.workbook.WorkBook;

import java.io.Serializable;

/**
 * Created by harji on 4/29/16.
 */
public class HeaderBean implements Serializable {

    public WorkBook setHeaderWorkbook( WorkBook workBook){
        return workBook;
    }
}
