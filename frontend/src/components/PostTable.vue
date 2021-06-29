<template>
  <v-simple-table>
    <template v-slot:default>
      <thead>
        <tr>
          <th class="text-left">번호</th>
          <th class="text-left">작성자</th>
          <th class="text-left">제목</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in desserts" :key="item.name" @click="getDetail(item)">
          <td>{{ item.id }}</td>
          <td>{{ item.name }}</td>
          <td>제목</td>
        </tr>
      </tbody>
    </template>
  </v-simple-table>
</template>

<script>
export default {
  methods: {
    getDetail: function (item) {
      console.log(item);
      this.$router.push({ name: "PostDetail", params: { id: item.id } });
    },
  },
  data() {
    return {
      desserts: [
        {
          id: 1,
          name: "Frozen Yogurt",
          calories: 159,
        },
        {
          id: 2,
          name: "Ice cream sandwich",
          calories: 237,
        },
        {
          id: 3,
          name: "Eclair",
          calories: 262,
        },
        {
          id: 4,
          name: "Cupcake",
          calories: 305,
        },
        {
          id: 5,
          name: "Gingerbread",
          calories: 356,
        },
        {
          id: 6,
          name: "Jelly bean",
          calories: 375,
        },
        {
          id: 7,
          name: "Lollipop",
          calories: 392,
        },
        {
          id: 8,
          name: "Honeycomb",
          calories: 408,
        },
        {
          id: 10,
          name: "Donut",
          calories: 452,
        },
        {
          id: 11,
          name: "KitKat",
          calories: 518,
        },
      ],
    };
  },
};
</script>
