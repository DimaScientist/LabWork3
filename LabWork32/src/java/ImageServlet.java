/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;


public class ImageServlet extends HttpServlet {

    static final String CONTENT_TYPE = "image/jpeg";
    
    static final int WIDTH = 120;
    static final int HEIGHT = 640;
    
    static final String CONTENT = "Hello World";
    
    static final String FONT_TYPE = "Times New Roman";
    static final int FONT_SIZE = 72;
    
    static final int X = 100;
    static final int Y = 100;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        try (ServletOutputStream out = response.getOutputStream()) {
            
            BufferedImage image = new BufferedImage(HEIGHT, WIDTH, 
                    BufferedImage.TYPE_INT_RGB);
            
            Graphics graphics = image.getGraphics();
            graphics.setFont(new Font(FONT_TYPE, Font.BOLD, FONT_SIZE));
            
            Random rnd = new Random();
            graphics.setColor(new Color(
                            rnd.nextInt(256), 
                            rnd.nextInt(256), 
                            rnd.nextInt(256)
                    ));
            graphics.drawString(CONTENT, X, Y);
            ImageIO.write(image, "jpeg", out);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
