package GUI;

import java.awt.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import BLL.StudentBLL;
import DTO.StudentDTO;

public class Statistics extends JPanel {
    private StudentBLL studentBLL;
    private JPanel chartPanel;

    public Statistics() {
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(240, 242, 245));
        studentBLL = new StudentBLL();

        JPanel titlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(0, 120, 215);
                Color color2 = new Color(0, 150, 255);
                GradientPaint gp = new GradientPaint(0, 0, color1, w, 0, color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        titlePanel.setPreferredSize(new Dimension(0, 60));
        JLabel titleLabel = new JLabel("Statistics", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(240, 242, 245));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JButton btnStudentsByGender = createStyledButton("Students by Gender");
        JButton btnConductScore = createStyledButton("Conduct Score");
        JButton btnAcademicScore = createStyledButton("Academic Score");

        buttonPanel.add(btnStudentsByGender);
        buttonPanel.add(btnConductScore);
        buttonPanel.add(btnAcademicScore);

        chartPanel = new JPanel(new BorderLayout());
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1, true),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        add(buttonPanel, BorderLayout.CENTER);
        add(chartPanel, BorderLayout.SOUTH);

        btnStudentsByGender.addActionListener(e -> displayStudentsByGender());
        btnConductScore.addActionListener(e -> displayConductScoreDistribution());
        btnAcademicScore.addActionListener(e -> displayAcademicScoreDistribution());
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int w = getWidth();
                int h = getHeight();
                Color color1 = new Color(0, 120, 215);
                Color color2 = new Color(0, 150, 255);
                GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
                g2.setPaint(isEnabled() ? gp : new Color(150, 150, 150));
                g2.fillRoundRect(0, 0, w, h, 15, 15);
                super.paintComponent(g);
                g2.dispose();
            }
        };
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setForeground(Color.WHITE);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(180, 40));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(new Color(230, 230, 230));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.WHITE);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                button.setForeground(new Color(200, 200, 200));
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.WHITE);
            }
        });

        return button;
    }

    private void displayStudentsByGender() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int maleCount = 0;
        int femaleCount = 0;

        for (StudentDTO student : studentBLL.getAllStudents()) {
            if (student.isGender()) {
                maleCount++;
            } else {
                femaleCount++;
            }
        }

        dataset.addValue(maleCount, "Students", "Male");
        dataset.addValue(femaleCount, "Students", "Female");

        JFreeChart chart = ChartFactory.createBarChart(
                "Number of Students by Gender",
                "Gender",
                "Number of Students",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        customizeChart(chart);
        updateChartPanel(chart);
    }

    private void displayConductScoreDistribution() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int[] ranges = {0, 50, 75, 100};
        String[] labels = {"0-50", "51-75", "76-100"};
        int[] counts = new int[3];

        for (StudentDTO student : studentBLL.getAllStudents()) {
            int score = student.getConductScore();
            if (score <= 50) {
                counts[0]++;
            } else if (score <= 75) {
                counts[1]++;
            } else {
                counts[2]++;
            }
        }

        for (int i = 0; i < labels.length; i++) {
            dataset.addValue(counts[i], "Students", labels[i]);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Conduct Score Distribution",
                "Score Range",
                "Number of Students",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        customizeChart(chart);
        updateChartPanel(chart);
    }

    private void displayAcademicScoreDistribution() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        float[] ranges = {0, 4, 7, 10};
        String[] labels = {"0-4", "4-7", "7-10"};
        int[] counts = new int[3];

        for (StudentDTO student : studentBLL.getAllStudents()) {
            float score = student.getAcademicScore();
            if (score <= 4) {
                counts[0]++;
            } else if (score <= 7) {
                counts[1]++;
            } else {
                counts[2]++;
            }
        }

        for (int i = 0; i < labels.length; i++) {
            dataset.addValue(counts[i], "Students", labels[i]);
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Academic Score Distribution",
                "Score Range",
                "Number of Students",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        customizeChart(chart);
        updateChartPanel(chart);
    }

    private void customizeChart(JFreeChart chart) {
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setFont(new Font("Segoe UI", Font.BOLD, 18));
        chart.getTitle().setPaint(new Color(30, 30, 30));

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(245, 245, 245));
        plot.setDomainGridlinePaint(new Color(200, 200, 200));
        plot.setRangeGridlinePaint(new Color(200, 200, 200));

        BarRenderer renderer = new BarRenderer() {
            @Override
            public Paint getItemPaint(int row, int column) {
                return new GradientPaint(0f, 0f, new Color(0, 120, 215), 0f, 0f, new Color(0, 150, 255));
            }
        };
        renderer.setDrawBarOutline(false);
        renderer.setBaseToolTipGenerator((dataset, row, column) ->
        dataset.getRowKey(row) + ": " + dataset.getValue(row, column).intValue());

        renderer.setSeriesPaint(0, new GradientPaint(0.0f, 0.0f, Color.WHITE, 0.0f, 0.0f, new Color(0, 162, 255)));
        plot.setRenderer(renderer);
    }

    private void updateChartPanel(JFreeChart chart) {
        chartPanel.removeAll();
        ChartPanel chartComponent = new ChartPanel(chart);
        chartComponent.setPreferredSize(new Dimension(600, 400));
        chartPanel.add(chartComponent, BorderLayout.CENTER);
        chartPanel.revalidate();
        chartPanel.repaint();
    }
}