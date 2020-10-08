import domain.model.Post
import kotlin.js.Date

val featuredPosts: List<Post> = listOf(
    Post(
        id = 1,
        userId = 1,
        title = "Title of a longer featured blog post",
        description = "Multiple lines of text that form the lede, informing new readers quickly and efficiently about what's most interesting in this post's contents.",
        body = "Test Post Body",
        image = "https://source.unsplash.com/random",
        linkText = "continue reading...",
        link = "#",
        date = Date.now()
    ),
    Post(
        id = 2,
        userId = 1,
        title = "Title of a longer featured blog post",
        description = "Multiple lines of text that form the lede, informing new readers quickly and efficiently about what's most interesting in this post's contents.",
        body = "Test Post Body",
        image = "https://source.unsplash.com/random",
        linkText = "continue reading...",
        link = "#",
        date = Date.now()
    ),
)