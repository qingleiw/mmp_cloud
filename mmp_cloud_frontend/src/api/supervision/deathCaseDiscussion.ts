import request from '@/utils/request';

// 查询死亡病例讨论列表
export function listDeathCase(query: any) {
  return request({
    url: '/supervision/death-case-discussion/list',
    method: 'get',
    params: query
  });
}

// 查询死亡病例讨论详细
export function getDeathCase(id: any) {
  return request({
    url: '/supervision/death-case-discussion/' + id,
    method: 'get'
  });
}

// 新增死亡病例讨论
export function addDeathCase(data: any) {
  return request({
    url: '/supervision/death-case-discussion',
    method: 'post',
    data: data
  });
}

// 修改死亡病例讨论
export function updateDeathCase(data: any) {
  return request({
    url: '/supervision/death-case-discussion',
    method: 'put',
    data: data
  });
}

// 删除死亡病例讨论
export function delDeathCase(id: any) {
  return request({
    url: '/supervision/death-case-discussion/' + id,
    method: 'delete'
  });
}

// 导出死亡病例讨论
export function exportDeathCase(query: any) {
  return request({
    url: '/supervision/death-case-discussion/export',
    method: 'post',
    params: query
  });
}
