package com.example;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.io.File;

public class FileExplorerGUI extends JFrame {

    private FileManager fileManager;

    public FileExplorerGUI(FileManager fileManager) {
        this.fileManager = fileManager;
        setTitle("File Explorer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initWindow();
    }

    private void initWindow() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create the file system tree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("/");
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        File[] rootFiles = fileManager.listFiles("/");
        for (File file : rootFiles) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(file.getName());
            root.add(node);
            addChildren(node, file.getAbsolutePath());
        }
        JTree fileTree = new JTree(treeModel);
        fileTree.setRootVisible(false);
        fileTree.setShowsRootHandles(true);
        mainPanel.add(new JScrollPane(fileTree), BorderLayout.CENTER);

        getContentPane().add(mainPanel);
    }

    private void addChildren(DefaultMutableTreeNode node, String absolutePath) {
        File[] files = fileManager.listFiles(absolutePath);
        for (File file : files) {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());
            if (file.isDirectory()) {
                node.add(childNode);
                addChildren(childNode, file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        FileExplorerGUI window = new FileExplorerGUI(fileManager);
        window.setVisible(true);
    }

}
