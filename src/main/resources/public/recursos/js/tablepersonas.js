$("#grid-selection").bootgrid({
    ajax: true,
    ajaxSettings: {
        method: "GET",
        cache: false
    }

    post: function ()
    {
        /* To accumulate custom parameter with the request object */
        return {
            id: "b0df282a-0d67-40e5-8558-c9e93b7befed"
        };
    },
    url: "/api/persons",
    selection: true,
    multiSelect: false,
    formatters: {
        "link": function(column, row)
        {
            return "<a href=\"#\">" + column.id + ": " + row.id + "</a>";
        }
    }
});