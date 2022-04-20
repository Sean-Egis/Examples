quickSearch() { //TODO quick search
    new Dialog({


        title: 'Quick Search',
        submitTitle: 'Search',
        fields: [
            {
                type: 'combo',
                label: 'Department',
                name: 'department',
                data: [
                    1, 2, 3
                ]
            },
            {
                type: 'combo',
                label: 'Region',
                name: 'region',
                data: [4, 5, 6]
            },
            {
                type: 'text',
                label: 'Search',
                name: 'search',
            }
        ],
        submit: async function (form) {
            router.routeTo('#node/' + ${form.values.department} +'/' +${form.values.region} +'?query=SELECT * FROM' +
                '' +${form.values.department} Node + 'WHERE filter %3D ' +
                '' +${form.values.search} +' AND region %3D ' +
                '' +${form.values.region} +' AND department %3D ' +
                '' +${form.values.department} +'');


        }
    }).show()
}

{
    type: 'combo',
    url: '/data/NodeLevels',
    onChange: function () {
        let fld = this;
        this.form.sub_cluster.setRemoteUrl(`/data/NodeLevels?parent=${encodeURI(fld.form.department.value + '/' + 
            fld.form.region.value + '/'+ fld.form.site.value + '/' + fld.form.cluster.value + '/' + fld.value)}`);
    }

}

