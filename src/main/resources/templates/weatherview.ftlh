<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WeatherApi</title>
</head>
    <body>
        <h1>API погода</h1>
        <h3>Добавить данные</h3>
        <form action="/value/add" method="post">
            Дата: <input type="date" name="date"/>
            Температура в цельсиях: <input type="number" name="temperatureC"/>
            <input type="submit" value="Добавить"/>
        </form>
        <hr>
        <#list values as value>
            <div>
                <div class="value">
                    <p>
                        Дата: ${value.date}, Температура С: ${value.temperatureC}, Температура F: ${value.temperatureF()}
                    </p>
                    <form action="/value/remove/${value.id}" method="post">
                        <input type="submit" value="Удалить"/>
                    </form>
                </div>
                <div class="value-change">
                    <form action="/value/change/${value.id}" method="post" id="form${value.id}" class="hide">
                        Дата: <input type="date" name="date"/>
                        Температура в цельсиях: <input type="number" name="temperatureC"/>
                        <input type="submit" value="Сохранить"/>
                    </form>
                    <button id="btn${value.id}">Изменить</button>
                </div>
            </div>
        </#list>
    </body>
<script>
    const buttons = document.querySelectorAll('button');
    buttons.forEach(button => {
        button.onclick = function () {
            if(document.getElementById('form' + button.id.replace('btn', '')).classList.contains("hide")) {
                document.getElementById('form' + button.id.replace('btn', '')).classList.remove("hide")
                button.textContent = 'Отменить'
            } else {
                document.getElementById('form' + button.id.replace('btn', '')).classList.add("hide")
                button.textContent = 'Изменить'
            }
        }
    })
</script>
<style>
    .value {
        display: flex;
        gap: 10px;
        align-items: center;
    }
    .value-change {
        display: flex;
        gap: 10px;
        align-items: center;
    }
    .hide {
        display: none;
    }
</style>
</html>
