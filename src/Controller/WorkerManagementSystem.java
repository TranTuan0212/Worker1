/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.WorkerView;

/**
 *
 * @author sonhu
 */
public class WorkerManagementSystem {
    public static void main(String[] args) {
        WorkerView view = new WorkerView();
        WorkerController controller = new WorkerController(view);
        controller.run();
    }
}
