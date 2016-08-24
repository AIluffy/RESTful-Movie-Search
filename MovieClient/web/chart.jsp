<%-- 
    Document   : chart
    Created on : 2015-8-17, 13:33:00
    Author     : AI
--%>

<%@page import="entity.Chart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chart</title>
        <script type="text/javascript" src="jquery.js"></script>
        <script type="text/javascript" src="js/highcharts.js"></script>
        <script type="text/javascript">
            $(function () {
                var mood = document.getElementById("mood").value.toString();
                var prob = document.getElementById("prob").value.toString();
                var prob1, prob2, anti_mood
                if (mood === 'positive') {
                    prob1 = prob * 100;
                    prob2 = 100 - prob1;
                    anti_mood = 'negative'
                } else {
                    prob2 = prob * 100;
                    prob1 = 100 - prob2;
                    anti_mood = 'positive'
                }

                $('#container').highcharts({
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false
                    },
                    title: {
                        text: 'The consumer attitude'
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: true,
                                color: '#000000',
                                connectorColor: '#000000',
                                format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                            }
                        }
                    },
                    series: [{
                            type: 'pie',
                            name: 'attitude',
                            data: [
                                [mood, prob1],
                                [anti_mood, prob2]
                            ]
                        }]
                });
            });
        </script>
    </head>
    <body>
        <div id="container" style="min-width:800px;height:400px;"></div>
        <div>
            <input type="hidden" id="mood" value=<%=request.getAttribute("mood")%>>
            <input type="hidden" id="prob" value=<%=request.getAttribute("prob")%>>
        </div>
    </body>
</html>
