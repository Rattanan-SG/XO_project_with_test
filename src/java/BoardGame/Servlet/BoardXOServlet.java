/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoardGame.Servlet;

import BoardGame.Models.BoardXO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nan
 */
public class BoardXOServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        if(session.getAttribute("BoardXO") == null){
            session.setAttribute("BoardXO", new BoardXO());
        }else{
            BoardXO board = (BoardXO) session.getAttribute("BoardXO");
            
            String positionString = request.getParameter("position");
            HashMap playMap = board.playerPlayAtPosition(positionString);
            int playAtRow = (Integer)playMap.get("row");
            int playAtColumn = (Integer)playMap.get("column");
            String playSymbol = (String)playMap.get("symbol");
        
            if(board.checkPositionInBoardIsEmpty(playAtRow, playAtColumn)){
                board.play(playAtRow, playAtColumn, playSymbol);
            }
            
            if (board.checkTurnFive()) {
                boolean isWin = false;
                if (board.checkWinRow(playAtRow, playSymbol)) {
                    isWin = true;
                }else if(board.checkWinColumn(playAtColumn, playSymbol)){
                    isWin = true;
                }else if(board.checkWinDiagonally(playSymbol)){
                    isWin = true;
                }
                
                if(isWin){
                    board.increaseWinScore();
                    board.createBoard();
                    request.setAttribute("message", playSymbol+" win");
                }else if(board.checkTurnNine()){
                    board.increaseTieScore();
                    board.createBoard();
                    request.setAttribute("message", "Tie");
                }
            }
            
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
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
