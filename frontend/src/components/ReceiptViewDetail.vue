<template>

    <v-card outlined>
        <v-card-title>
            Receipt # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="Type" v-model="item.type" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ReceiptViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/receipts/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

