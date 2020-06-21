export class CommentModel {

    commentId: number;
    content: string;
    author: string;
    advertId: number;

  constructor(id: number, name: string, advertId: number ){
  this.commentId = id;
  this.content = name;
  this.advertId = advertId;
}
}
