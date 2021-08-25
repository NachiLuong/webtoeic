package vn.nacl.core.common.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UploadUtil {
    private final int maxMemorySize = 1024*1024*3;
    private final int maxRequestSize = 1024*1024*50;

    public  Object[]  writeOrUpdateFile(HttpServletRequest request, Set<String> titleValue, String path) throws FileUploadException, Exception {
        ServletContext context=request.getServletContext();
        String address = context.getRealPath("image");
        boolean check=true;
        String fileLocation=null;
        String name=null;
        Map<String,String> mapReturnValue= new HashMap<String,String>();
        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(!isMultipart) check=false;
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Set factory constraints
        factory.setSizeThreshold(maxMemorySize);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(maxRequestSize);

        // Parse the request
        List<FileItem> items = upload.parseRequest(request);
        for(FileItem item:items){
            if(!item.isFormField()){
                String fileName=item.getName();
                File upLoadFile= new File(address + File.separator+ path + File.separator + fileName);
                System.out.println(address+ File.separator+ path + File.separator);
                boolean isExist=upLoadFile.exists();
                if(isExist){
                    if(upLoadFile.delete()) check=true;
                    else check=false;
                }
                item.write(upLoadFile);
            }
            else {
                if(titleValue!=null){
                    String nameField= item.getFieldName();
                    String valueField=item.getString();
                    if(titleValue.contains(nameField)){
                        mapReturnValue.put(nameField,valueField);
                    }
                }
            }
        }
        return new  Object[]{check, fileLocation, name, mapReturnValue};
    }
}
