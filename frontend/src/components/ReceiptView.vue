<template>

    <v-data-table
        :headers="headers"
        :items="receipt"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ReceiptView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "type", value: "type" },
            ],
            receipt : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/receipts'))

            temp.data._embedded.receipts.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.receipt = temp.data._embedded.receipts;
        },
        methods: {
        }
    }
</script>

