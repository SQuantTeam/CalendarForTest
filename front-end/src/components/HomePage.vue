<template>
    <div>
        <div class="background">
            <el-card class="card next-date">
                <div slot="header" class="clearfix">
                    <span>下一天是哪一天？</span>
                </div>
                <div class="block">
                    <el-date-picker
                    v-model="next_date_input"
                    type="date"
                    value-format="yyyy-MM-dd"
                    placeholder="选择日期">
                    </el-date-picker>
                </div>
                <el-button type="primary" class="caculate" @click="get_next_date">计算</el-button>
                <span v-show="next_date_result.is_valid">{{next_date_result.year}} 年 {{next_date_result.month}} 月 {{next_date_result.date}} 日</span>
            </el-card>

            <el-card class="card next-date">
                <div slot="header" class="clearfix">
                    <span>某一天是星期几？</span>
                </div>
                <div class="block">
                    <el-date-picker
                    v-model="this_day_input"
                    type="date"
                    placeholder="选择日期">
                    </el-date-picker>
                </div>
                <el-button type="primary" class="caculate">计算</el-button>
                星期 {{this_day_result.day}} 

            </el-card>

            <el-card class="card next-date">
                <div slot="header" class="clearfix">
                    <span>两个日期间相差多少天？</span>
                </div>
                <div class="block">
                    <el-date-picker
                    v-model="between_dates"
                    type="daterange"
                    range-separator="至"
                    start-placeholder="开始日期"
                    end-placeholder="结束日期">
                    </el-date-picker>
                </div>
                <el-button type="primary" class="caculate">计算</el-button>
                {{between_dates_result.counts}} 天
            </el-card>

            <el-card class="card next-date">
                <div slot="header" class="clearfix">
                    <span>推算几天后的日期？</span>
                </div>
                <div class="block">
                    <el-date-picker
                    v-model="dates_post"
                    type="date"
                    placeholder="选择日期">
                    </el-date-picker>
                </div>
                <el-button type="primary" class="caculate">计算</el-button>
                {{dates_post_result.year}} 年 {{dates_post_result.month}} 月 {{dates_post_result.date}} 日

            </el-card>

        </div>
        
    </div>
</template>

<style scoped>
.background {
  position: absolute;
  width: 100%;
  height: 100%;
  background-image: url(../assets/background.jpg);
  background-size: 100% 100%;
  top: 0;
  padding-left: 10%;
  padding-right: 10%;
}

.card {
  width: 400px;
  height: 200px;
  position: relative;
  position: relative;
  margin: 6% 10%;
  opacity: 0.95;
  float: left;
}

.caculate {
  position: relative;
  margin-top: 5%;
  /* margin-left: -40%; */
  margin-right: 5%;
}
</style>


<script>
import axios from "axios";
export default {
  data() {
    return {
      para: ["date", "month", "year"],
      next_date_input: "",
      this_day_input: "",
      between_dates: "",
      dates_post: "",
      next_date_result: {
        year: "",
        month: "",
        date: "",
        is_valid: false
      },
      this_day_result: {
        day: "二"
      },
      dates_post_result: {
        year: 2012,
        month: 12,
        date: 31
      },
      between_dates_result: {
        counts: 10
      }
    };
  },
  methods: {
    get_next_date() {
      console.log(this.next_date_input);
      var next_date_input = this.next_date_input.split("-");
      console.log(typeof this.next_date_input);
      var self = this;
      var year = next_date_input[0];
      var month = next_date_input[1];
      var date = next_date_input[2];
      console.log(year, month, date);

      var result = {
        year: " ",
        month: " ",
        date: " ",
        is_valid: true
      };

      axios
        .get("http://localhost:8088/calendar/dateOfNextDay", {
          params: { year: year, month: month, day: date },
          headers: {
            "X-Requested-With": "XMLHttpRequest",
            "Access-Control-Allow-Origin": "*"
          }
        })
        .then(function(response) {
          console.log(response);
          result.date = response.data;
        })
        .catch(function(error) {
          alert(error);
        });

      axios
        .get("http://localhost:8088/calendar/monthOfNextDay", {
          params: { year: year, month: month, day: date },
          headers: {
            "X-Requested-With": "XMLHttpRequest",
            "Access-Control-Allow-Origin": "*"
          }
        })
        .then(function(response) {
          console.log(response);
          result.month = response.data;
        })
        .catch(function(error) {
          alert(error);
        });

      axios
        .get("http://localhost:8088/calendar/yearOfNextDay", {
          params: { year: year, month: month, day: date },
          headers: {
            "X-Requested-With": "XMLHttpRequest",
            "Access-Control-Allow-Origin": "*"
          }
        })
        .then(function(response) {
          console.log(response);
          result.year = response.data;
        })
        .catch(function(error) {
          alert(error);
        });

      console.log(result);
      this.next_date_result = result;
    },
    
    get_this_day() {
      console.log(this.next_date_input);
      console.log(this.next_date_input.getDate());
      var self = this;
      var year = this.next_date_input.getYear();
      var month = this.next_date_input.getMonth();
      var date = this.next_date_input.getDate();
      var url = "http://localhost:8087/HelloAST/calendar/dayOfThisDay";
    }
  }
};
</script>

