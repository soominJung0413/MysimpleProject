<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020-08-24
  Time: 오후 7:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"  %>


<style>
    #slider-div *:focus {
        outline:none;
    }
</style>

<div class="container">

    <div style="width: 100%; height: 70%; ">
        <div id="slider-div"  >
            <div onclick="window.open('https://github.com/soominJung0413')" style="cursor: pointer; ">
                <img id="item1" src="/resources/img/github.png" >
                </img>
                <p id="itemPara1" >
                    My GitHub
                    (●'◡'●)
                    <br>
                    <br>
                    <br>
                    <br>
                </p>
            </div>
            <div onclick="window.open('https://doli0413.tistory.com/')" style="cursor: pointer">
                <img id="item2" src="/resources/img/tistory.png" >
                </img>
                <p id="itemPara2">
                    MyTitory
                    (❁´◡`❁)
                </p>
            </div>
            <div onclick="window.open('https://doli0413.tistory.com/')" style="cursor: pointer">
                <img id="item3" src="/resources/img/tistory.png" >
                </img>
                <p id="itemPara3">
                    MyTitory
                    (❁´◡`❁)
                </p>
            </div>
            <div onclick="window.open('https://www.google.com')" style="cursor: pointer">
                <img id="item4" src="/resources/img/google.png" >
                </img>
                <p id="itemPara4">
                   Google!
                    (⌐■_■)
                </p>
            </div>

        </div>
    </div>
</div>
